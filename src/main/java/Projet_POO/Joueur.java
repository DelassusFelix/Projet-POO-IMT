package Projet_POO;

public class Joueur extends Personnage {

    Capacite capacite; 
    int score; 

    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom){
        super(nom, pv, force, defense, esquive, critique);
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