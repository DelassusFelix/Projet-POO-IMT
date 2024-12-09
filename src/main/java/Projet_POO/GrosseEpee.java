package Projet_POO;

/**
 * Classe GrosseEpee.
 * Représente une capacité passive qui double la force du personnage
 * lorsqu'elle est activée. Cette capacité est un objet utilisable qui
 * améliore la force du personnage.
 * Hérite de la classe {@link Utilitaire} et implémente l'interface
 * {@link CapacitePassiveInterface}.
 */
public class GrosseEpee extends Utilitaire implements CapacitePassiveInterface {

    /**
     * Constructeur de GrosseEpee.
     * Initialise la capacité avec un label et un nom.
     * Le label décrit l'effet de la capacité et le nom fait référence à
     * l'objet ("Grosse Epée").
     */
    public GrosseEpee(){
        super("Voici une meilleure épée !", "Grosse Epée");
    }

    /**
     * Applique l'effet de la grosse épée en doublant la force du personnage.
     *
     * @param personnage Le personnage sur lequel la capacité est appliquée.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacite passive grosse épée");
        personnage.force = personnage.force * 2;
    }

    /**
     * Affiche les informations sur l'objet, y compris son nom et son label.
     */
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
