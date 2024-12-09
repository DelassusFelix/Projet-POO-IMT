package Projet_POO;

public class CocktailMolotov extends Utilitaire implements CapaciteActiveInterface, CapaciteAffectantEnnemi {

    public boolean isDisponible = true; 

    public int count = 1; 

    public CocktailMolotov(){
        super("Ca va chauffer.. brule tout les ennemis d'un seul coup", "Cocktail Molotov");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active Cocktail Molotov ");
        personnage.setPv(personnage.getPv() - 30); 
    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo; 
    }

    @Override
    public int getCount(){
        return this.count; 
    }
    
}
