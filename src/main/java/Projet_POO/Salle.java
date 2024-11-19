package Projet_POO;

import java.util.ArrayList;

public class Salle {
    String nom;
    ArrayList ennemis = new ArrayList<>();

    public Salle(String nom, ArrayList ennemis) {
        this.nom = nom;
        this.ennemis = ennemis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList getEnnemis() {
        return ennemis;
    }

    public void setEnnemis(ArrayList ennemis) {
        this.ennemis = ennemis;
    }
}
