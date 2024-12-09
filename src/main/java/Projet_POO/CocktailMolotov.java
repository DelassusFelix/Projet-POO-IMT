package Projet_POO;

public class CocktailMolotov extends Utilitaire implements CapaciteActiveInterface {

    public CocktailMolotov(){
        super("Ca va chauffer.. brule tout les ennemis d'un seul coup", "Cocktail Molotov");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active Cocktail Molotov ");
        // METTRE LES DEGATS AUX ENEMIES ICI

    }
    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
    public String getLabel(){
        return this.label;
    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
    
}
