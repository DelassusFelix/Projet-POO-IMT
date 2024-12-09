package Projet_POO;

import java.util.List;

/**
 * Représente une carte composée de plusieurs pièces à travers lesquelles le joueur peut se déplacer.
 * La carte garde une trace de la position actuelle du joueur et gère l'avancement à travers les différentes pièces.
 */
public class Carte {
    private String nom;
    private List<String> pieces;
    private int positionActuelle;

    /**
     * Constructeur de la carte.
     *
     * @param nom Le nom de la carte.
     * @param pieces La liste des pièces qui composent la carte.
     */
    public Carte(String nom, List<String> pieces) {
        this.nom = nom;
        this.pieces = pieces;
        this.positionActuelle = 0;
    }

    /**
     * Retourne le nom de la carte.
     *
     * @return Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la position actuelle du joueur sur la carte.
     *
     * @return La position actuelle du joueur.
     */
    public int getPositionActuelle() {
        return positionActuelle;
    }

    /**
     * Retourne la pièce actuelle du joueur sur la carte.
     * Si le joueur est hors limites, retourne "Aucune pièce".
     *
     * @return Le nom de la pièce actuelle ou un message si aucune pièce n'est disponible.
     */
    public String getPieceActuelle() {
        if (positionActuelle < pieces.size()) {
            return pieces.get(positionActuelle);
        }
        return "Aucune pièce.";
    }

    /**
     * Vérifie si le joueur a atteint la fin de la carte.
     *
     * @return true si la position actuelle est égale ou supérieure au nombre total de pièces, sinon false.
     */
    public boolean estArrivee() {
        return positionActuelle >= pieces.size();
    }

    /**
     * Avance le joueur à la pièce suivante sur la carte.
     */
    public void avancer() {
        positionActuelle++;
    }

    /**
     * Retourne la longueur de la carte, c'est-à-dire le nombre total de pièces.
     *
     * @return La taille de la carte (nombre de pièces).
     */
    public int getLongueur() {
        return pieces.size();
    }
}
