public class Joueur extends Personnage{

    String nom;
    String capacite; 

    public Joueur(int pv, int force, int defense, int esquive, String nom, String capacite){
        super(pv, force, defense, esquive);
        this.nom = nom;
        this.capacite = capacite; 
    }

    @Override
    public String toString(){
        String data = super.toString();
        return data + "\nnom : " + nom + "\ncapacite : " + capacite; 
    }



}