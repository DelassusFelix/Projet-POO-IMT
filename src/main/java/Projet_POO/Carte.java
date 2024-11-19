package Projet_POO;

import java.util.ArrayList;

public class Carte {
    String nom;
    ArrayList salles = new ArrayList<Salle>();

    public Carte(String nom, ArrayList salles) {
        this.nom = nom;
        this.salles = salles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList getSalles() {
        return salles;
    }

    public void setSalles(ArrayList salles) {
        this.salles = salles;
    }
}
