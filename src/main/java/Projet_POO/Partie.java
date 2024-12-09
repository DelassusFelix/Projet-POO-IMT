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
     * Cette méthode est responsable de la boucle principale du jeu, gérant les interactions avec le joueur.
     *
     * @throws Exception si une erreur survient lors de l'exécution
     */
    public void jouer() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean firstRound = true;
        boolean affichPosition = true;

        scanner.nextLine();
        logger.log("\nBienvenue dans l'aventure sur la carte \"" + carte.getNom() + "\".");
        logger.log("Bonne chance !");
        logger.log("-------------------------------------------------");

        while (!carte.estArrivee() && joueur.checkAlive()) {
            scanner.nextLine(); // Pause pour permettre au joueur d'interagir
            if (affichPosition) {
                logger.log("\n=== Position : " + (carte.getPositionActuelle() + 1) + " / " + carte.getLongueur() + " ===");
                logger.log(carte.getPieceActuelle());
            }
            affichPosition = false;

            logger.log(firstRound ? "\n1. Lancer la partie." : "\n1. Salle suivante");
            logger.log("2. Consulter l'état du héros");
            logger.log("3. Acheter un objet");
            System.out.print("> ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    if (ennemis.isEmpty()) {

                        if (!carte.estArrivee()) {
                            if (!firstRound) {
                                carte.avancer();
                            }
                            logger.log("\n=== Position : " + (carte.getPositionActuelle() + 1) + " / " + carte.getLongueur() + " ===");
                            logger.log(carte.getPieceActuelle());
                            genererEnnemis(carte.getPositionActuelle());
                        }

                        firstRound = false;
                        scanner.nextLine(); // Pour éviter de sauter la saisie suivante
                    } else {
                        logger.log("Tous les ennemis doivent être vaincus avant de pouvoir avancer !");
                    }
                    break;

                case 2:
                    afficherEtatHeros();
                    break;

                case 3:
                    logger.log("\n=== Bienvenue dans la boutique ===");
                    logger.log("\nQue voulez-vous acheter " + joueur.getNom() + " ?");
                    logger.log("Crédits : " + joueur.getScore() + "\n");
                    logger.log("0. Quitter la boutique");
                    logger.log("1. Petite potion (prix : " + petitePotion.getCout() + ")");

                    choix = scanner.nextInt();
                    scanner.nextLine();

                    if (choix == 0) {
                        logger.log("Vous quittez la boutique.");
                        break;
                    }

                    if (choix == 1) {
                        if (joueur.getScore() > petitePotion.getCout()) {
                            joueur.addObjet(petitePotion);
                            joueur.setScore(joueur.getScore() - petitePotion.getCout());
                            logger.log("Achat effectué avec succès !");
                        } else {
                            logger.log("Vous n'avez pas assez de crédits.");
                        }
                    } else {
                        logger.log("Choix invalide !");
                    }
                    break;

                default:
                    logger.log("Choix invalide !");
            }

            // Combats avec les ennemis
            while (!ennemis.isEmpty() && joueur.checkAlive()) {
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
                logger.log("Bravo ! Vous avez traversé \"" + carte.getNom() + "\" !");
                xml.modifyXML(carte, joueur.getScore(), joueur.getNom());
                scanner.nextLine();
                break;
            }
        }
    }

    /**
     * Affiche l'état actuel du héros, incluant ses points de vie, sa force, et ses statistiques.
     */
    private void afficherEtatHeros() throws IOException {
        logger.log("\n=== État du héros ===");
        logger.log("PV : " + joueur.getPv() + " / " + joueur.getPvMax());
        logger.log("Force : " + joueur.getForce());
        logger.log("Coup critique : " + joueur.getCritique() + " %");
        logger.log("Défense : " + joueur.getDefense());
        logger.log("Esquive : " + joueur.getEsquive() + " %");
        joueur.showObjets();
        logger.log("\n\n");
    }

    /**
     * Supprime les ennemis morts (PV <= 0) de la liste des ennemis.
     */
    private void nettoyerEnnemis() {
        ennemis.removeIf(ennemi -> !ennemi.checkAlive());
    }

    /**
     * Permet au joueur de choisir un ennemi parmi ceux disponibles.
     *
     * @param scanner l'objet Scanner pour la saisie utilisateur
     * @return l'ennemi sélectionné ou null si le choix est invalide
     */
    private Personnage choisirEnnemi(Scanner scanner) throws IOException {
        if (!joueur.checkAlive()) {
            logger.log("Vous êtes mort. La partie est terminée.");
            return null;
        }

        nettoyerEnnemis();

        if (ennemis.isEmpty()) {
            logger.log("Tous les ennemis ont été vaincus !");
            return null;
        }

        logger.log("\n=== Choisissez un ennemi à combattre ===");
        for (int i = 0; i < ennemis.size(); i++) {
            MechantInterface ennemi = (MechantInterface) ennemis.get(i); // cast
            logger.log((i + 1) + ". " + ennemi.getNom() + " (lvl: " + ennemi.getNiveau() + " ,PV: " + ennemi.getPv() + ")");
        }
        System.out.print("> ");
        int choix = scanner.nextInt();

        if (choix < 1 || choix > ennemis.size()) {
            logger.log("Choix invalide !");
            return null;
        }

        return ennemis.get(choix - 1);
    }

    /**
     * Gère le combat entre le joueur et un ennemi spécifique.
     *
     * @param ennemi l'ennemi à combattre
     */
    private void combat(Personnage ennemi) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int scoreGagne = ennemi.getPv();

        int countCapacite = 0;
        boolean capaciteActive = false;

        while (joueur.checkAlive() && ennemi.checkAlive()) {

            afficherBarresDeVie(ennemi);

            // Afficher les options disponibles
            logger.log("1. Attaquer");
            logger.log("2. Fuir");
            logger.log("3. Utiliser un objet");
            if (joueur.capacite.isDisponible() && countCapacite < joueur.capacite.getCount()) {
                logger.log("4. Utiliser votre capacité");
            }

            System.out.print("> ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pause nécessaire

            if (choix == 1) {
                joueur.attaque(ennemi);

                if (capaciteActive) {
                    if (countCapacite < joueur.capacite.getCount()) {
                        countCapacite += 1;
                    } else {
                        capaciteActive = false;
                        joueur.capacite.reverseEffect(joueur);
                        joueur.capacite.setDisponible(false);
                    }
                }

                if (!ennemi.checkAlive()) {
                    logger.log("Vous avez vaincu " + ennemi.getNom() + " !");
                    logger.log("Vous avez gagné : " + scoreGagne + " crédits");
                    joueur.setScore(joueur.getScore() + scoreGagne);
                    ennemis.remove(ennemi);
                    logger.log("Vous avez vaincu " + ennemi.getNom() + " !");
                    break;
                } else {
                    ennemi.attaque(joueur);
                    if (!joueur.checkAlive()) {
                        logger.log("Vous êtes mort pendant le combat.");
                        break;
                    }
                }
            } else if (choix == 2) {
                if (Math.random() > 0.5) {
                    logger.log("Vous avez réussi à fuir !");
                    break;
                } else {
                    logger.log("Échec de la fuite. L'ennemi attaque !");
                    ennemi.attaque(joueur);
                    if (!joueur.checkAlive()) {
                        logger.log("Vous êtes mort pendant le combat.");
                        break;
                    }
                }
            } else if (choix == 4 && joueur.capacite.isDisponible() && countCapacite < joueur.capacite.getCount()) {
                capaciteActive = true;
                if (joueur.capacite instanceof CapaciteAffectantEnnemi) {
                    joueur.capacite.useEffect(ennemi);
                } else {
                    joueur.capacite.useEffect(joueur);
                }
                countCapacite += 1;
            } else if (choix == 3) {
                logger.log(joueur.showObjets());
                joueur.useObjets();
            } else {
                logger.log("Choix invalide !");
            }
        }
    }

    /**
     * Affiche les barres de vie du joueur et de l'ennemi.
     *
     * @param ennemi l'ennemi en cours de combat
     */
    private void afficherBarresDeVie(Personnage ennemi) throws IOException {
        int joueurPvMax = Math.max(joueur.getPvMax(), 1);
        int ennemiPvMax = Math.max(ennemi.getPvMax(), 1);

        int joueurPvRestant = Math.max(joueur.getPv(), 0);
        int ennemiPvRestant = Math.max(ennemi.getPv(), 0);

        int joueurBarLength = Math.min(50, joueurPvRestant * 50 / joueurPvMax);
        int ennemiBarLength = Math.min(50, ennemiPvRestant * 50 / ennemiPvMax);

        String joueurBarre = "[" + "=".repeat(joueurBarLength) + " ".repeat(50 - joueurBarLength) + "]";
        String ennemiBarre = "[" + "=".repeat(ennemiBarLength) + " ".repeat(50 - ennemiBarLength) + "]";

        logger.log("\nVotre vie : " + joueurBarre + " " + joueurPvRestant + "/" + joueurPvMax);
        logger.log(ennemi.getNom() + " vie : " + ennemiBarre + " " + ennemiPvRestant + "/" + ennemiPvMax);
    }
}
