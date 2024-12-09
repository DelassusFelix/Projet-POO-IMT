package Projet_POO;

/**
 * Classe abstraite Capacite.
 * Représente une capacité avec un nom et une description.
 * Les sous-classes peuvent définir des effets spécifiques à appliquer ou à inverser sur un personnage.
 */
public abstract class Capacite {

    /** Nom de la capacité. */
    public String nom;

    /** Description ou étiquette de la capacité. */
    public String label;

    /**
     * Constructeur de la classe Capacite.
     * Initialise une capacité avec un nom et une description.
     *
     * @param label La description ou l'étiquette de la capacité.
     * @param nom   Le nom de la capacité.
     */
    public Capacite(String label, String nom) {
        this.label = label;
        this.nom = nom;
    }

    /**
     * Applique l'effet de la capacité à un personnage.
     * Doit être implémentée par les sous-classes si un effet spécifique est requis.
     *
     * @param personnage Le personnage sur lequel appliquer l'effet.
     */
    public void useEffect(Personnage personnage) {
    }

    /**
     * Inverse l'effet de la capacité sur un personnage.
     * Doit être implémentée par les sous-classes si une inversion d'effet est nécessaire.
     *
     * @param personnage Le personnage sur lequel inverser l'effet.
     */
    public void reverseEffect(Personnage personnage) {
    }

}
