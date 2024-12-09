package Projet_POO;

/**
 * Classe LameAiguise.
 * Représente une capacité active qui double les chances de critique du
 * personnage pendant 3 attaques. Cette capacité améliore les chances de
 * critique pendant un nombre limité d'attaques et peut être inversée une fois
 * que le nombre d'utilisations est atteint.
 * Hérite de la classe {@link Utilitaire} et implémente l'interface
 * {@link CapaciteActiveInterface}.
 */
public class LameAiguise extends Utilitaire implements CapaciteActiveInterface {

    /**
     * Indicateur de disponibilité de la capacité.
     * Si cette capacité est disponible, elle peut être utilisée.
     */
    public boolean isDisponible = true;

    /**
     * Compteur du nombre d'utilisations restantes de la capacité.
     * La capacité peut être utilisée jusqu'à 3 fois avant de devenir inactive.
     */
    public int count = 3;

    /**
     * Constructeur de LameAiguise.
     * Initialise la capacité avec un label et un nom.
     * Le label décrit l'effet de la capacité et le nom fait référence à
     * l'objet ("Lame Aiguisée").
     */
    public LameAiguise(){
        super("Affuté.. double tes chances de critique pendant 3 attaques. Ca va piquer !", "Lame Aiguisée");
    }

    /**
     * Applique l'effet de la capacité Lame Aiguisée en doublant les chances de
     * critique du personnage pendant 3 attaques.
     *
     * @param personnage Le personnage sur lequel la capacité est appliquée.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active lame aiguisée");
        personnage.critique = personnage.critique * 2;
        // AJOUTER UN COMPTEUR, la capacité fonctionne pour 3 attaques
    }

    /**
     * Annule l'effet de la capacité Lame Aiguisée en réinitialisant les chances
     * de critique du personnage.
     *
     * @param personnage Le personnage sur lequel la capacité doit être inversée.
     */
    @Override
    public void reverseEffect(Personnage personnage){
        System.out.println("Votre lame s'est brisé ... ");
        personnage.critique = personnage.critique / 2;
    }

    /**
     * Affiche les informations sur l'objet, y compris son nom et son label.
     */
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    /**
     * Définit si la capacité est disponible ou non.
     *
     * @param dispo Un booléen qui détermine si la capacité est disponible.
     */
    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo;
    }

    /**
     * Retourne le nombre d'utilisations restantes de la capacité.
     *
     * @return Le nombre d'utilisations restantes.
     */
    @Override
    public int getCount(){
        return this.count;
    }

}
