package Projet_POO;

/**
 * Classe CasqueChantier.
 * Représente un casque de chantier qui peut être utilisé comme une capacité active.
 * Lorsqu'il est utilisé, il double la défense du personnage pendant 3 attaques, après quoi il est brisé.
 */
public class CasqueChantier extends Utilitaire implements CapaciteActiveInterface {

    /** Indique si la capacité est disponible. */
    public boolean isDisponible = true;

    /** Compteur du nombre d'utilisations restantes. */
    public int count = 3;

    /**
     * Constructeur de CasqueChantier.
     * Initialise le casque de chantier avec une description et un nom.
     */
    public CasqueChantier(){
        super("Enfile ton casque ! Double ta défense pendant 3 attaques", "Casque de Chantier");
    }

    /**
     * Applique l'effet du casque de chantier sur un personnage.
     * Double la défense du personnage pendant 3 attaques.
     *
     * @param personnage Le personnage sur lequel appliquer l'effet.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("Vous enfilez votre casque de chantier ! Défense x2 pendant 3 tours.");
        personnage.defense = personnage.defense * 2;
    }

    /**
     * Inverse l'effet du casque de chantier lorsque celui-ci est brisé.
     * Restaure la défense du personnage à son niveau normal.
     *
     * @param personnage Le personnage dont la défense doit être restaurée.
     */
    @Override
    public void reverseEffect(Personnage personnage){
        System.out.println("Votre casque de chantier est brisé ... ");
        personnage.defense = personnage.defense / 2;
    }

    /**
     * Définit l'état de disponibilité de la capacité.
     *
     * @param dispo Un booléen indiquant si le casque est disponible (true) ou non (false).
     */
    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo;
    }

    /**
     * Affiche les informations du casque de chantier.
     */
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    /**
     * Obtient le nombre d'utilisations restantes pour le casque de chantier.
     *
     * @return Le nombre d'utilisations restantes.
     */
    @Override
    public int getCount(){
        return this.count;
    }
}
