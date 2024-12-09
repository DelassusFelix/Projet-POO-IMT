package Projet_POO;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Personnage {

    private List<CapaciteActive> inventaire;
    int score; 

    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom){
        super(nom, pv, force, defense, esquive, critique);
        this.inventaire = new ArrayList<>();
    }

    @Override
    public String toString(){
        String data = super.toString();
        return data + "\nnom : " + nom;

    }

    public List<CapaciteActive> getInventaire() {
        return inventaire;
    }

    public void ajouterCapacite(CapaciteActive capacite) {
        inventaire.add(capacite);
    }

    public void utiliserCapacite(int index) {
        if (index >= 0 && index < inventaire.size()) {
            CapaciteActive capacite = inventaire.get(index);
            capacite.useEffect(this); // Applique l'effet sur le joueur
        } else {
            System.out.println("Choix invalide !");
        }
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score; 
    }

    public void augmenteScore(int value){
        int score = getScore();
        score= score + value;
        setScore(score); 
    }
}