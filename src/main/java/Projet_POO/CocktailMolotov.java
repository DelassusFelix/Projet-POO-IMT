package Projet_POO;

/**
 * Classe CocktailMolotov.
 * Représente un objet utilisable dans le jeu avec une capacité active
 * qui inflige des dégâts à un personnage. Le Cocktail Molotov est un objet
 * qui brûle tous les ennemis en infligeant des dégâts directs.
 * Hérite de la classe {@link Utilitaire} et implémente les interfaces
 * {@link CapaciteActiveInterface} et {@link CapaciteAffectantEnnemi}.
 */
public class CocktailMolotov extends Utilitaire implements CapaciteActiveInterface, CapaciteAffectantEnnemi {

    /**
     * Indicateur de disponibilité de l'objet.
     */
    public boolean isDisponible = true;

    /**
     * Nombre d'utilisations restantes de l'objet (1 utilisation maximum).
     */
    public int count = 1;

    /**
     * Constructeur de CocktailMolotov.
     * Initialise l'objet Cocktail Molotov avec un nom et un label.
     */
    public CocktailMolotov(){
        super("Ca va chauffer.. brule tous les ennemis d'un seul coup", "Cocktail Molotov");
    }

    /**
     * Applique l'effet du Cocktail Molotov sur un personnage.
     * Cet effet inflige 30 points de dégâts au personnage cible.
     *
     * @param personnage Le personnage sur lequel l'effet est appliqué.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active Cocktail Molotov ");
        personnage.setPv(personnage.getPv() - 30);
    }

    /**
     * Affiche le nom et le label de l'objet Cocktail Molotov.
     */
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    /**
     * Définit si l'objet est disponible pour être utilisé.
     *
     * @param dispo Indicateur de disponibilité de l'objet.
     */
    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo;
    }

    /**
     * Retourne le nombre d'utilisations restantes pour cet objet.
     *
     * @return Le nombre d'utilisations restantes (1 dans ce cas).
     */
    @Override
    public int getCount(){
        return this.count;
    }
}
