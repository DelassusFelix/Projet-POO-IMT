package Projet_POO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant une partie du jeu.
 * Elle gère le déroulement de l'aventure, les interactions entre le joueur, la carte, et les ennemis.
 */
public class Partie {
    private Joueur joueur;
    private Carte carte;
    private List<Personnage> ennemis;
    private Logger logger;

    PetitePotion petitePotion = new PetitePotion();
    XML xml = new XML();


    /**
     * Constructeur de la classe Partie.
     * Initialise un joueur, une carte, un logger, et une liste d'ennemis.
     *
     * @param hero  le joueur participant à la partie
     * @param carte la carte sur laquelle se déroule l'aventure
     * @throws IOException si une erreur survient lors de l'initialisation du logger
     */
    public Partie(Joueur hero, Carte carte) throws IOException {
        this.joueur = hero;
        this.carte = carte;
        this.logger = new Logger("partie");
        this.ennemis = new ArrayList<>();
    }

    /**
     * Génère une liste d'ennemis pour une salle donnée de la carte.
     * Le type et le nombre d'ennemis sont déterminés aléatoirement.
     *
     * @param position la position actuelle du joueur sur la carte
     */
    public void genererEnnemis(int position) {
        Random rand = new Random();
        ennemis.clear();
        int nbEnnemis = rand.nextInt(3) + 1;

        for (int i = 0; i < nbEnnemis; i++) {
            int chance = rand.nextInt(100);
            int niveau = rand.nextInt(3) + 1;
            if (chance < 20) {
                Catcheur ennemi = new Catcheur("Catcheur");
                ennemi.setNiveauMechant(position + niveau);
                ennemis.add(ennemi);
            } else if (chance < 55) {
                Brigand ennemi = new Brigand("Brigand");
                ennemi.setNiveauMechant(position + niveau);
                ennemis.add(ennemi);
            } else {
                Voleur ennemi = new Voleur("Voleur");
                ennemi.setNiveauMechant(position + niveau);
                ennemis.add(ennemi);
            }
        }
    }

    /**
     * Démarre et gère le déroulement principal de la partie.
     *
     * @throws Exception si une erreur survient lors de l'exécution
     */
    public void jouer() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean firstRound = true;
        boolean affichPosition = true;

        scanner.nextLine();
        System.out.println("\nBienvenue dans l'aventure sur la carte \"" + carte.getNom() + "\".");
        System.out.println("Bonne chance !");
        System.out.println("-------------------------------------------------");

        while (!carte.estArrivee() && joueur.checkAlive()) {
            scanner.nextLine(); // Pause pour permettre au joueur d'interagir
            if (affichPosition) {
                System.out.println("\n=== Position : " + (carte.getPositionActuelle() + 1) + " / " + carte.getLongueur() + " ===");
                System.out.println(carte.getPieceActuelle());
            }
            affichPosition = false;

            System.out.println(firstRound ? "\n1. Lancer la partie." : "\n1. Salle suivante");
            System.out.println("2. Consulter l'état du héros");
            System.out.println("3. Acheter un objet");
            System.out.print("> ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    if (ennemis.isEmpty()) {
                        if (!firstRound) {
                            carte.avancer();
                            System.out.println("\n=== Position : " + (carte.getPositionActuelle() + 1) + " / " + carte.getLongueur() + " ===");
                            logger.log(carte.getPieceActuelle());
                        }
                        if (!carte.estArrivee()) {
                            genererEnnemis(carte.getPositionActuelle());
                        }
                        firstRound = false;
                        scanner.nextLine(); // Pour éviter de sauter la saisie suivante
                    } else {
                        System.out.println("Tous les ennemis doivent être vaincus avant de pouvoir avancer !");
                    }
                    break;

                case 2:
                    afficherEtatHeros();
                    break;

                case 3: 
                    System.out.println("\n=== Bienvenue dans la boutique ===");
                    System.out.println("\nCrédits : " + joueur.getScore());
                    System.out.println("Que voulez-vous acheter " + joueur.getNom() + " ?");

                    System.out.println("1. Petite potion (prix : " + petitePotion.getCout() + ")");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    if (choix == 1) {
                        if (joueur.getScore() > petitePotion.getCout()){
                            joueur.addObjet(petitePotion); 
                            joueur.setScore(joueur.getScore() - petitePotion.getCout()); 
                            System.out.println("Achat effecuté avec succès");
                        } else {
                            System.out.println("Vous n'avez pas assez de crédits.");
                        }
                    }
                    break; 

                default:
                    System.out.println("Choix invalide !");
            }

            // Combats avec les ennemis
            while (!ennemis.isEmpty() && joueur.checkAlive()) { // Vérifie si le joueur est vivant
                Personnage ennemi = choisirEnnemi(scanner);
                if (ennemi != null) {
                    combat(ennemi);
                }
            }

            // Vérifie si le joueur est mort après un combat
            if (!joueur.checkAlive()) {
                logger.log("\nGame Over. Vous êtes mort.");
                xml.modifyXML(carte, joueur.getScore(), joueur.getNom());
                break;
            }

            // Conditions de victoire
            if (carte.estArrivee() && joueur.checkAlive()) {
                System.out.println("Bravo ! Vous avez traversé \"" + carte.getNom() + "\" !");
                xml.modifyXML(carte, joueur.getScore(), joueur.getNom());
                scanner.nextLine();
                break;
            }
        }
    }


    /**
     * Affiche l'état actuel du héros, incluant ses points de vie, sa force, et ses statistiques.
     */
    private void afficherEtatHeros() {
        System.out.println("\n=== État du héros ===");
        System.out.println("PV : " + joueur.getPv() + " / " + joueur.getPvMax());
        System.out.println("Force : " + joueur.getForce());
        System.out.println("Coup critique : " + joueur.getCritique() + " %");
        System.out.println("Défense : " + joueur.getDefense());
        System.out.println("Esquive : " + joueur.getEsquive() + " %");
        joueur.showObjets();
    }

    /**
     * Permet au joueur de choisir un ennemi parmi ceux disponibles.
     *
     * @param scanner l'objet Scanner pour la saisie utilisateur
     * @return l'ennemi sélectionné ou null si le choix est invalide
     */
    private Personnage choisirEnnemi(Scanner scanner) {
        if (!joueur.checkAlive()) {
            System.out.println("Vous êtes mort. La partie est terminée.");
            return null;
        }

        System.out.println("\n=== Choisissez un ennemi à combattre ===");
        for (int i = 0; i < ennemis.size(); i++) {
            MechantInterface ennemi = (MechantInterface) ennemis.get(i); // cast
            System.out.println((i + 1) + ". " + ennemi.getNom() + " (lvl: " + ennemi.getNiveau() + " ,PV: " + ennemi.getPv() + ")");
        }
        System.out.print("> ");
        int choix = scanner.nextInt();

        if (choix < 1 || choix > ennemis.size()) {
            System.out.println("Choix invalide !");
            return null;
        }

        return ennemis.get(choix - 1);
    }


    /**
     * Gère le combat entre le joueur et un ennemi spécifique.
     *
     * @param ennemi l'ennemi à combattre
     */
    private void combat(Personnage ennemi) {
        Scanner scanner = new Scanner(System.in);

        int scoreGagne = ennemi.getPv();

        while (joueur.checkAlive() && ennemi.checkAlive()) {
        
            afficherBarresDeVie(ennemi);

            System.out.println("1. Attaquer");
            System.out.println("2. Fuir");
            System.out.println("3. Utiliser votre capacité");
            System.out.println("4. Utiliser un objet");
            System.out.print("> ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pause nécessaire

            if (choix == 1) {
                joueur.attaque(ennemi);
                if (!ennemi.checkAlive()) {
                    System.out.println("Vous avez vaincu " + ennemi.getNom() + " !"); 
                    System.out.println("Vous avez gagnez : " + scoreGagne + " point de score");
                    joueur.setScore(joueur.getScore() + scoreGagne); 
                    ennemis.remove(ennemi);
                    System.out.println("Vous avez vaincu " + ennemi.getNom() + " !");
                    break;
                } else {
                    ennemi.attaque(joueur);
                    if (!joueur.checkAlive()) {
                        System.out.println("Vous êtes mort pendant le combat.");
                        break; // Sort du combat
                    }
                }
            } else if (choix == 2) {
                if (Math.random() > 0.5) {
                    System.out.println("Vous avez réussi à fuir !");
                    break;
                } else {
                    System.out.println("Échec de la fuite. L'ennemi attaque !");
                    ennemi.attaque(joueur);
                    if (!joueur.checkAlive()) {
                        System.out.println("Vous êtes mort pendant le combat.");
                        break;
                    }
                }
            } else if (choix == 3) {
                joueur.capacite.useEffect(joueur);
            } else if (choix == 4) {
                System.out.println(joueur.showObjets()); 
                joueur.useObjets();
            } else {
                System.out.println("Choix invalide !");
            }
        }
    }






    /**
     * Affiche les barres de vie du joueur et de l'ennemi.
     *
     * @param ennemi l'ennemi en cours de combat
     */
    private void afficherBarresDeVie(Personnage ennemi) {
        int joueurPvMax = Math.max(joueur.getPvMax(), 1);
        int ennemiPvMax = Math.max(ennemi.getPvMax(), 1);

        int joueurPvRestant = Math.max(joueur.getPv(), 0);
        int ennemiPvRestant = Math.max(ennemi.getPv(), 0);

        int joueurBarLength = Math.min(50, joueurPvRestant * 50 / joueurPvMax);
        int ennemiBarLength = Math.min(50, ennemiPvRestant * 50 / ennemiPvMax);

        String joueurBarre = "[" + "=".repeat(joueurBarLength) + " ".repeat(50 - joueurBarLength) + "]";
        String ennemiBarre = "[" + "=".repeat(ennemiBarLength) + " ".repeat(50 - ennemiBarLength) + "]";

        System.out.println("\nVotre vie : " + joueurBarre + " " + joueurPvRestant + "/" + joueurPvMax);
        System.out.println(ennemi.getNom() + " vie : " + ennemiBarre + " " + ennemiPvRestant + "/" + ennemiPvMax);
    }
}
