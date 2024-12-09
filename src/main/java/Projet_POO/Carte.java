package Projet_POO;

import java.util.List;

public class Carte {
    private String nom;
    private List<String> pieces;
    private int positionActuelle; // Position actuelle sur la carte

    public Carte(String nom, List<String> pieces) {
        this.nom = nom;
        this.pieces = pieces;
        this.positionActuelle = 0; // Début au premier emplacement
    }

    public String getNom() {
        return nom;
    }

    public int getPositionActuelle() {
        return positionActuelle;
    }

    public String getPieceActuelle() {
        if (positionActuelle < pieces.size()) {
            return pieces.get(positionActuelle);
        }
        return "Aucune pièce.";
    }

    public boolean estArrivee() {
        return positionActuelle >= pieces.size();
    }

    public void avancer() {
            positionActuelle++;
    }

    public int getLongueur() {
        return pieces.size();
    }
}
