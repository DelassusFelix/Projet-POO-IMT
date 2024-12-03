package Projet_POO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partie {
    private Joueur joueur;
    private Carte carte;
    private List<Personnage> ennemis;
    private Logger logger;

    public Partie(Joueur hero, Carte carte) throws IOException {
        this.joueur = hero;
        this.carte = carte;
        this.logger = new Logger("partie");
        this.ennemis = new ArrayList<>();
    }

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

        System.out.println("Des ennemis vous attendent !");
        for (Personnage ennemi : ennemis) {
            System.out.println("- " + ennemi.getNom() + " (PV : " + ennemi.getPv() + ")");
        }
    }

    public void jouer() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans l'aventure sur la carte \"" + carte.getNom() + "\" à \"" + carte.getLieu() + "\".");
        System.out.println("Bonne chance !");
        System.out.println("-------------------------------------------------");
        scanner.nextLine();

        while (!carte.estArrivee() && joueur.checkAlive()) {
            System.out.println("\n=== Position : " + (carte.getPositionActuelle() + 1) + " / " + carte.getLongueur() + " ===");
            System.out.println("Description : " + carte.getPieceActuelle());
            System.out.println("1. Avancer");
            System.out.println("2. Consulter l'état du héros");
            System.out.print("> ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    // Avant d'avancer, on vérifie s'il reste des ennemis dans la pièce
                    if (ennemis.isEmpty()) {
                        carte.avancer();  // Le joueur peut avancer si tous les ennemis sont vaincus
                        logger.log("Avance. Nouvelle position : " + carte.getPositionActuelle());
                        if (!carte.estArrivee()) {
                            genererEnnemis(carte.getPositionActuelle());
                        }
                        scanner.nextLine();
                    } else {
                        System.out.println("Tous les ennemis doivent être vaincus avant de pouvoir avancer !");
                    }
                    break;

                case 2:
                    System.out.println("\n=== État du héros ===");
                    System.out.println("PV : " + joueur.getPv());
                    System.out.println("Force : " + joueur.getForce());
                    scanner.nextLine();
                    break;

                default:
                    System.out.println("Choix invalide !");
                    continue;
            }

            if (!ennemis.isEmpty()) {
                System.out.println("\n--- Un combat commence ! ---");
                combat();
            }

            if (carte.estArrivee() && joueur.checkAlive()) {
                System.out.println("Bravo ! Vous avez traversé \"" + carte.getNom() + "\" !");
                scanner.nextLine();
                break;
            }
        }

        if (!joueur.checkAlive()) {
            System.out.println("Game Over. Vous êtes mort.");
            logger.log("Mort du héros.");
        }
    }



    private void combat() {
        Scanner scanner = new Scanner(System.in);

        // Boucle de combat tant que le joueur est en vie et qu'il y a des ennemis
        while (joueur.checkAlive() && !ennemis.isEmpty()) {
            Personnage ennemi = ennemis.get(0);  // Récupérer le premier ennemi de la liste

            afficherBarresDeVie(ennemi);  // Affiche les barres de vie avant chaque action

            System.out.println("1. Attaquer");
            System.out.println("2. Fuir");
            System.out.print("> ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                joueur.attaque(ennemi);  // Attaque du joueur
                if (!ennemi.checkAlive()) {
                    System.out.println("Vous avez vaincu " + ennemi.getNom() + " !");
                    ennemis.remove(ennemi);  // L'ennemi est vaincu, on le retire de la liste
                } else {
                    ennemi.attaque(joueur);  // Attaque de l'ennemi
                }
            } else if (choix == 2) {
                if (Math.random() > 0.5) {
                    System.out.println("Vous avez réussi à fuir !");
                    scanner.nextLine();
                    break;  // Si la fuite réussit, on sort du combat
                } else {
                    System.out.println("Échec de la fuite. L'ennemi attaque !");
                    ennemi.attaque(joueur);  // L'ennemi attaque après l'échec de la fuite
                    scanner.nextLine();
                }
            } else {
                System.out.println("Choix invalide !");
            }
        }

        if (!joueur.checkAlive()) {
            System.out.println("Vous êtes mort !");
            scanner.nextLine();
        } else if (ennemis.isEmpty()) {
            System.out.println("Vous avez vaincu tous les ennemis !");
        }
    }


    private void afficherBarresDeVie(Personnage ennemi) {
        int joueurPvMax = Math.max(joueur.getPvMax(), 1); // Empêche pvMax de valoir 0
        int ennemiPvMax = Math.max(ennemi.getPvMax(), 1);

        int joueurPvRestant = Math.max(joueur.getPv(), 0); // Empêche des valeurs négatives
        int ennemiPvRestant = Math.max(ennemi.getPv(), 0);

        // Calcul des proportions de barres de vie
        int joueurBarLength = Math.min(50, joueurPvRestant * 50 / joueurPvMax);
        int ennemiBarLength = Math.min(50, ennemiPvRestant * 50 / ennemiPvMax);

        String joueurBarre = "[" + "=".repeat(joueurBarLength) + " ".repeat(50 - joueurBarLength) + "]";
        String ennemiBarre = "[" + "=".repeat(ennemiBarLength) + " ".repeat(50 - ennemiBarLength) + "]";

        // Affichage des barres de vie
        System.out.println("\n=== Combat en cours ===");
        System.out.println("Votre vie : " + joueurBarre + " " + joueurPvRestant + "/" + joueurPvMax);
        System.out.println(ennemi.getNom() + " vie : " + ennemiBarre + " " + ennemiPvRestant + "/" + ennemiPvMax);
    }



}
