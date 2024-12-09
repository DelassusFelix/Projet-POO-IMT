package Projet_POO;

/**
 * Classe CGrosseEpee.
 * Représente une capacité passive appelée "Grosse épée".
 * Cette capacité augmente la force du personnage en doublant sa force actuelle.
 * Hérite de la classe {@link Capacite} et implémente l'interface {@link CapacitePassive}.
 */
public class CGrosseEpee extends Capacite implements CapacitePassive {

    /**
     * Constructeur de CGrosseEpee.
     * Initialise la capacité "Grosse épée" avec un label et un nom spécifiques.
     */
    public CGrosseEpee(){
        super("Voici une meilleure épée !", "Grosse épée");
    }

    /**
     * Applique l'effet de la capacité passive "Grosse épée" sur un personnage.
     * Cette capacité double la force du personnage.
     *
     * @param personnage Le personnage sur lequel l'effet est appliqué.
     */
    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité passive grosse épée");
        personnage.force = personnage.force * 2;
    }
}
