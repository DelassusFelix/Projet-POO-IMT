package Projet_POO;

public class Brigand extends Personnage implements MechantInterface{

    String nom;
    int niveau;

    public Brigand(String nom){
        super(nom,3,3,2,2,2);
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
    public Brigand setNiveauMechant(int niveau){
        this.niveau = niveau;
        this.pvMax = 30 * niveau;
        this.pv = this.pvMax;
        this.force = 5 * niveau;
        this.defense = (float) (0.3 * niveau);
        this.esquive = 3 * niveau;
        this.critique = 4 * niveau;

        Brigand brigand = new Brigand("brigand");

        return brigand;
    }

    @Override
    public void attaque(){}


}