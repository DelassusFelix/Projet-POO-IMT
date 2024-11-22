package Projet_POO;

public class Joueur extends Personnage{

    String nom;
    Capacite capacite; 

    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom){
        super(pv, force, defense, esquive, critique);
        this.nom = nom; 
    }

    @Override
    public String toString(){
        String data = super.toString();
        return data + "\nnom : " + nom; 
    }

    public Capacite getCapacite(){
        return this.capacite; 
    }

    public void setCapacite(Capacite capacite){
        this.capacite = capacite;
    }




}