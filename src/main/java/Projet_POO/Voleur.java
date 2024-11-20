public class Voleur extends Personnage implements MechantInterface{

    String nom; 
    int niveau;

    public Voleur(String nom){
        super(2,2,2,3,3);
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
    public Voleur setNiveauMechant(int niveau){
        this.niveau = niveau; 
        this.pv = 10 * niveau; 
        this.force = 2 * niveau; 
        this.defense = (float) (0.2 * niveau); 
        this.esquive = 5 * niveau;
        this.critique = 10 * niveau; 

        Voleur voleur = new Voleur("voleur");

        return voleur;
    }



}