package Projet_POO;

/**
 * Classe GilletParBalle.
 * Représente une capacité passive qui augmente la défense du personnage
 * de 1 point lorsqu'elle est activée. Cette capacité est un objet utilisable
 * qui peut être appliqué pour améliorer les défenses du personnage.
 * Hérite de la classe {@link Utilitaire} et implémente l'interface
 * {@link CapacitePassiveInterface}.
 */
public class GilletParBalle extends Utilitaire implements CapacitePassiveInterface {

    /**
     * Constructeur de GilletParBalle.
     * Initialise la capacité avec un label et un nom.
     * Le label indique l'effet de la capacité et le nom décrit l'objet.
     */
    public GilletParBalle(){
        super("Pas de place aux doutes. Mets ton gilet, sois fort et gagne 1 point de défense", "Gillet par Balle");
    }

    /**
     * Applique l'effet du gilet par balle, augmentant la défense du personnage
     * de 1 point.
     *
     * @param personnage Le personnage sur lequel la capacité est appliquée.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacite passive Gillet par Balles");
        personnage.defense = personnage.defense + 1;
    }

    /**
     * Affiche les informations sur l'objet, y compris son nom et son label.
     */
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
