package Projet_POO;

public class Catcheur extends Personnage implements MechantInterface{

    String nom; 
    int niveau;

    public Catcheur(String nom){
        super(nom,3,2,3,2,2);
        this.nom = nom;
    }

    @Override
    public String getNom(){
        return this.nom;
    }

    public int getNiveau() {
        return niveau;
    }

    @Override
    public String toString(){
        String data = super.toString();
        return "\nnom : " + nom + "\nniv : " + niveau + data;
    }

    @Override
    public Catcheur setNiveauMechant(int niveau){
        this.niveau = niveau;
        this.pvMax = 35 * niveau;
        this.pv = this.pvMax;
        this.force = 6 * niveau;
        this.defense = (float) (0.5 * niveau);
        this.esquive = 3 * niveau;
        this.critique = 5 * niveau;

        Catcheur catcheur = new Catcheur("voleur");

        return catcheur;
    }

    @Override
    public void attaque(){}



}