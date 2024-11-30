package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partie {
    private Joueur joueur;
    private Carte carte;
    private List<Personnage> ennemis;
    private Logger logger;

    public Partie(Joueur hero, Carte carte, Logger logger) {
        this.joueur = hero;
        this.carte = carte;
        this.logger = logger;
        this.ennemis = new ArrayList<>();
    }

    // Méthode pour générer des ennemis sur le parcours
    public void genererEnnemis() {
        Random rand = new Random();
        for (int i = 0; i < carte.getPositionActuelle(); i++) {
            if (rand.nextInt(10) < 4) { // 40% de chance d'ajouter un ennemi
                Brigand ennemi = new Brigand();  // Ajoutez ici d'autres types d'ennemis
                ennemis.add(ennemi);
            }
        }
    }

    // Méthode pour gérer le combat entre le héros et un ennemi
    public void combattre(Personnage ennemi) throws Exception {
        logger.log("Le héros commence à combattre un ennemi.");

        // Le héros attaque en premier
        joueur.attaquer(ennemi);
        if (!ennemi.estVivant()) {
            logger.log("L'ennemi a été vaincu.");
            ennemis.remove(ennemi);
        } else {
            // L'ennemi attaque ensuite
            ennemi.attaquer(hero);
            if (!joueur.estVivant()) {
                logger.log("Le héros est mort.");
                throw new Exception("Le héros est mort.");
            }
        }
    }

    // Méthode pour faire avancer le jeu
    public void jouer() throws Exception {
        while (!carte.estArrivee() && joueur.estVivant()) {
            // Avancer sur la carte
            carte.avancer();
            logger.log("Le héros avance. Position actuelle : " + carte.getPositionActuelle());

            // Le héros peut rencontrer des ennemis
            if (ennemis.size() > 0) {
                Personnage ennemi = ennemis.get(0); // Rencontre avec le premier ennemi
                logger.log("Le héros rencontre un ennemi.");
                combattre(ennemi);
            }

            // Logique de victoire (si on atteint la fin de la carte)
            if (carte.estArrivee()) {
                logger.log("Le héros a atteint la fin de la carte et a gagné !");
                break;
            }
        }

        // Si le héros est mort avant la fin
        if (!joueur.estVivant()) {
            logger.log("Le héros a perdu !");
        }



    }

    
}
