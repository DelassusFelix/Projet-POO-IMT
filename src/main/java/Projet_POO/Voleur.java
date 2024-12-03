package Projet_POO;

public class Voleur extends Personnage implements MechantInterface{

    String nom; 
    int niveau;

    public Voleur(String nom){
        super(nom,2,2,2,3,3);
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
    public Voleur setNiveauMechant(int niveau){
        this.niveau = niveau;
        this.pvMax = 20 * niveau;
        this.pv =this.pvMax;
        this.force = 4 * niveau;
        this.defense = (float) (0.25 * niveau);
        this.esquive = 7 * niveau;
        this.critique = 12 * niveau;

        Voleur voleur = new Voleur("voleur");

        return voleur;
    }



}