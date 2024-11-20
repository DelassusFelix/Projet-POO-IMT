public class Brigand extends Personnage implements MechantInterface{

    String nom; 
    int niveau;

    public Brigand(String nom){
        super(3,3,2,2,2);
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
    public Brigand setNiveauMechant(int niveau){
        this.niveau = niveau; 
        this.pv = 20 * niveau; 
        this.force = 4 * niveau; 
        this.defense = (float) (0.2 * niveau); 
        this.esquive = 2 * niveau;
        this.critique = 3 * niveau; 

        Brigand brigand = new Brigand("brigand");

        return brigand;
    }



}