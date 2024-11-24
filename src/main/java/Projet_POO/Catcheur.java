package Projet_POO;

public class Catcheur extends Personnage implements MechantInterface{

    String nom; 
    int niveau;

    public Catcheur(String nom){
        super(3,2,3,2,2);
        this.nom = nom; 
    }

    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
    public String toString(){
        String data = super.toString();
        return "\nnom : " + nom + "\nniv : " + niveau + data;
    }

    @Override
    public Catcheur setNiveauMechant(int niveau){
        this.niveau = niveau; 
        this.pv = 20 * niveau; 
        this.force = 2 * niveau; 
        this.defense = (float) (0.4 * niveau); 
        this.esquive = 2 * niveau;
        this.critique = 3 * niveau; 

        Catcheur catcheur = new Catcheur("voleur");

        return catcheur;
    }



}