package Projet_POO;

/**
 * Représente une potion qui peut être utilisée par un personnage pour restaurer des points de vie.
 * La potion est une capacité active qui peut être utilisée pour soigner un personnage pendant le jeu.
 *
 * Elle étend la classe {@link Utilitaire} et implémente l'interface {@link CapaciteActiveInterface}.
 */
public class Potion extends Utilitaire implements CapaciteActiveInterface {

    /**
     * Indique si la potion est disponible pour être utilisée.
     */
    public boolean isDisponible = true;

    /**
     * Le nombre d'utilisations restantes pour cette potion.
     */
    public int count = 1;

    /**
     * Constructeur de la classe Potion.
     * Initialise la potion avec un nom et une description.
     */
    public Potion() {
        super("Une grande soif contre les grands dégâts. Restaure 30 PV", "Potion");
    }

    /**
     * Applique l'effet de la potion sur un personnage, en lui restaurer des points de vie.
     * La potion restaure 5 PV à un personnage, mais ne peut pas dépasser un maximum de 10 PV.
     *
     * @param personnage le personnage qui utilise la potion
     */
    @Override
    public void useEffect(Personnage personnage) {
        System.out.println("On a utilisé la capacité active potion");
        personnage.pv = personnage.pv + 5;
        if (personnage.pv > 10) {
            personnage.pv = 10;
        }
    }

    /**
     * Affiche le nom et la description de la potion.
     */
    public void afficher() {
        System.out.println(this.nom + ": \n" + this.label);
    }

    /**
     * Définit si la potion est disponible pour être utilisée.
     *
     * @param dispo le statut de disponibilité de la potion
     */
    @Override
    public void setDisponible(boolean dispo) {
        this.isDisponible = dispo;
    }

    /**
     * Renvoie le nombre d'utilisations restantes pour la potion.
     *
     * @return le nombre d'utilisations restantes
     */
    @Override
    public int getCount() {
        return this.count;
    }
}
