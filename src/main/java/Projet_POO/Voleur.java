public class Voleur extends Personnage implements MechantInterface{

    String nom; 

    public Voleur(int pv, int force, int defense, int esquive, String nom){
        super(pv, force, defense, esquive);
        this.nom = nom; 
    }

    @Override
    public String toString(){
        String data = super.toString();
        return data + "\nnom : " + nom;
    }

}