package Projet_POO;

import java.util.ArrayList;

/**
 * Représente une salle dans le jeu, qui contient des ennemis.
 * Chaque salle a un nom et une liste d'ennemis qui peuvent y être présents.
 */
public class Salle {

    /**
     * Le nom de la salle.
     */
    String nom;

    /**
     * Liste des ennemis présents dans la salle.
     */
    ArrayList ennemis = new ArrayList<>();

    /**
     * Constructeur de la classe Salle.
     * Initialise la salle avec un nom et une liste d'ennemis.
     *
     * @param nom     Le nom de la salle
     * @param ennemis La liste des ennemis présents dans la salle
     */
    public Salle(String nom, ArrayList ennemis) {
        this.nom = nom;
        this.ennemis = ennemis;
    }

    /**
     * Retourne le nom de la salle.
     *
     * @return le nom de la salle
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la salle.
     *
     * @param nom le nouveau nom de la salle
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la liste des ennemis présents dans la salle.
     *
     * @return la liste des ennemis
     */
    public ArrayList getEnnemis() {
        return ennemis;
    }

    /**
     * Définit la liste des ennemis présents dans la salle.
     *
     * @param ennemis la nouvelle liste des ennemis
     */
    public void setEnnemis(ArrayList ennemis) {
        this.ennemis = ennemis;
    }
}
