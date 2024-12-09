package Projet_POO;

import java.util.Scanner;

/**
 * Classe représentant un personnage avec des statistiques telles que PV (points de vie), force,
 * défense, esquive et critique. Permet de gérer les attaques, les vérifications d'état et les
 * interactions avec d'autres personnages.
 */
public class Personnage {
    /**
     * Nom du personnage.
     */
    String nom;

    /**
     * Points de vie actuels du personnage.
     */
    int pv;

    /**
     * Points de vie maximums du personnage.
     */
    int pvMax;

    /**
     * Force du personnage, utilisée pour calculer les dégâts infligés.
     */
    int force;

    /**
     * Défense du personnage, utilisée pour réduire les dégâts reçus.
     */
    float defense;

    /**
     * Probabilité d'esquive (en pourcentage) des attaques ennemies.
     */
    int esquive;

    /**
     * Probabilité de coup critique (en pourcentage) pour infliger des dégâts doublés.
     */
    int critique;

    /**
     * Indique si le personnage est mort.
     */
    boolean isDead = false;

    /**
     * Constructeur de la classe Personnage.
     *
     * @param nom      Nom du personnage.
     * @param pv       Points de vie initiaux.
     * @param force    Force du personnage.
     * @param defense  Défense du personnage.
     * @param esquive  Probabilité d'esquive.
     * @param critique Probabilité de coup critique.
     */
    public Personnage(String nom, int pv, int force, float defense, int esquive, int critique) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.force = force;
        this.defense = defense;
        this.esquive = esquive;
        this.critique = critique;
    }

    /**
     * Représentation textuelle des statistiques du personnage.
     *
     * @return Une chaîne de caractères décrivant les statistiques du personnage.
     */
    @Override
    public String toString() {
        return "\npv : " + this.pv + "/" + this.pvMax +
                "\nforce : " + this.force +
                "\ndef : " + this.defense +
                "\nesquive : " + this.esquive +
                "\ncritique : " + this.critique;
    }

    /**
     * Retourne le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du personnage.
     *
     * @param nom Nouveau nom du personnage.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Accesseurs et mutateurs pour les points de vie

    /**
     * Retourne les points de vie actuels.
     *
     * @return Les points de vie actuels.
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Modifie les points de vie actuels du personnage.
     *
     * @param pv Nouveaux points de vie. Si supérieur aux PV max, ils sont limités à la valeur maximale.
     */
    public void setPv(int pv) {
        if (pv > this.pvMax) {
            this.pv = this.pvMax;
        } else if (pv < 0) {
            this.pv = 0;
        } else {
            this.pv = pv;
        }
    }

    /**
     * Retourne les points de vie maximums.
     *
     * @return Les points de vie maximums.
     */
    public int getPvMax() {
        return this.pvMax;
    }

    /**
     * Modifie les points de vie maximums et ajuste les PV actuels si nécessaire.
     *
     * @param pvMax Nouveaux points de vie maximums.
     */
    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
        if (this.pv > pvMax) {
            this.pv = pvMax;
        }
    }

    // Autres accesseurs et mutateurs

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public float getDefense() {
        return this.defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public int getEsquive() {
        return this.esquive;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public int getCritique() {
        return this.critique;
    }

    public void setCritique(int critique) {
        this.critique = critique;
    }

    public boolean isDead() {
        return this.isDead;
    }

    /**
     * Vérifie si le personnage est en vie.
     *
     * @return {@code true} si les PV sont supérieurs à 0, sinon {@code false}.
     */
    public boolean checkAlive() {
        return this.pv > 0;
    }

    /**
     * Marque le personnage comme mort.
     */
    public void setDead() {
        this.isDead = true;
    }

    /**
     * Réalise une attaque contre un autre personnage.
     *
     * @param defenseur Le personnage attaqué.
     */
    public void attaque(Personnage defenseur) {
        float degat = 0;

        // Vérification de l'esquive
        int randomIntEsqu = (int) (Math.random() * 101);
        if (defenseur.getEsquive() > randomIntEsqu) {
            System.out.println((defenseur instanceof Joueur ? "Vous esquivez" : (defenseur.getNom() + " esquive")) + " l'attaque !");
            return;
        }

        // Calcul des dégâts
        int randomIntCrit = (int) (Math.random() * 101);
        if (this.getCritique() > randomIntCrit) {
            // Coup critique
            degat = ((this.getForce() * 2) / Math.max(1, defenseur.getDefense()));
            degat = Math.round(degat);
            System.out.println("Coup critique ! " + (this instanceof Joueur ? "Vous infligez " : (this.getNom() + " inflige ")) + degat + " dégâts !");
        } else {
            // Attaque normale
            degat = this.getForce() / Math.max(1, defenseur.getDefense());
            degat = Math.round(degat);
            System.out.println((this instanceof Joueur ? "Vous infligez " : (this.getNom() + " inflige ")) + degat + " dégâts !");
        }

        // Réduction des PV
        float nouveauPV = defenseur.getPv() - degat;
        defenseur.setPv(Math.max(0, Math.round(nouveauPV)));
    }
}
