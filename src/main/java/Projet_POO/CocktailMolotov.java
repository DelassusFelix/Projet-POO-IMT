package Projet_POO;

public class CocktailMolotov extends Capacite implements CapaciteActive {

    public CocktailMolotov(){
        super("Ca va chauffer.. brule tout les ennemis d'un seul coup");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active Cocktail Molotov ");
        // METTRE LES DEGATS AUX ENEMIES ICI

    }
    @Override
    public String getNom(){
        return this.label;
    }
}
