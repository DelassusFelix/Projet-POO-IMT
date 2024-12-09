package Projet_POO;

/**
 * Classe CPotion.
 * Représente une capacité active qui permet d'utiliser une potion pour
 * restaurer les points de vie d'un personnage. La capacité active
 * inflige une restauration de 30 points de vie au personnage ciblé.
 * Hérite de la classe {@link Capacite} et implémente l'interface
 * {@link CapaciteActive}.
 */
public class CPotion extends Capacite implements CapaciteActive {

    /**
     * Constructeur de CPotion.
     * Initialise la capacité avec un label et un nom.
     */
    public CPotion(){
        super("Vous utilisez une potion !", "Potion de vie");
    }

    /**
     * Applique l'effet de la potion, augmentant les points de vie du
     * personnage de 30 points.
     *
     * @param personnage Le personnage qui utilise la potion et bénéficie
     *                  de la restauration de points de vie.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active potion");
        personnage.pv = personnage.pv + 30;
    }

    /**
     * Retourne le nom de la capacité.
     *
     * @return Le nom de la capacité, qui est le label de la potion.
     */
    @Override
    public String getNom(){
        return this.label;
    }
}
