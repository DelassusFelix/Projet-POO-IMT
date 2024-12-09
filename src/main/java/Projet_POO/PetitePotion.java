package Projet_POO;

/**
 * Classe PetitePotion représentant un objet utilitaire permettant de régénérer une partie des PV (points de vie) d'un personnage.
 * Hérite de la classe Utilitaire et implémente l'interface ObjetInterface.
 */
public class PetitePotion extends Utilitaire implements ObjetInterface {

    /**
     * Coût de la petite potion.
     */
    public int cout = 25;

    /**
     * Constructeur de la classe PetitePotion.
     * Initialise une potion avec un nom par défaut.
     */
    public PetitePotion() {
        super("", "Petite potion");
    }

    /**
     * Applique l'effet de la petite potion sur un personnage.
     * La potion régénère 10% des PV max du personnage, sans dépasser ses PV max.
     *
     * @param personnage Le personnage sur lequel l'effet est appliqué.
     */
    @Override
    public void useEffect(Personnage personnage) {
        System.out.println("on a utilisé l'objet petite potion\n");
        personnage.pv = personnage.pv + (personnage.getPvMax() / 10);
        if (personnage.getPv() > personnage.getPvMax()) {
            personnage.setPv(personnage.getPvMax());
            System.out.println("mais vous ne pouvez pas avoir autant de pv.\n");
        }
    }

    /**
     * Retourne le coût de la petite potion.
     *
     * @return Le coût de la potion.
     */
    @Override
    public int getCout() {
        return this.cout;
    }
}
