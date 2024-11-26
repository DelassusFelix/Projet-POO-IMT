package Projet_POO;

public class Carte {
    private String nom;
    private String lieu;
    private int longueur;
    private int positionActuelle;

    public Carte(String nom, String lieu, int longueur) {
        this.nom = nom;
        this.lieu = lieu;
        this.longueur = longueur;
        this.positionActuelle = 0; // Position de départ
    }

    public void avancer() {
        if (positionActuelle < longueur) {
            positionActuelle++;
        }
    }

    public boolean estArrivee() {
        return positionActuelle == longueur;
    }

    public int getPositionActuelle() {
        return positionActuelle;
    }

    public String getNom() {
        return nom;
    }
}

