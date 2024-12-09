package Projet_POO;

/**
 * Classe PasDePlume représentant une capacité passive qui double la capacité d'esquive d'un personnage.
 * Hérite de la classe Utilitaire et implémente l'interface CapacitePassiveInterface.
 */
public class PasDePlume extends Utilitaire implements CapacitePassiveInterface {

    /**
     * Constructeur de la classe PasDePlume.
     * Initialise le nom et la description de la capacité.
     */
    public PasDePlume() {
        super("Agile bill, te voila leger comme l'air. Tu doubles ta capacité d'esquive", "Pas de plume");
    }

    /**
     * Applique l'effet de la capacité Pas de plume à un personnage.
     * Double la valeur de l'attribut d'esquive du personnage.
     *
     * @param personnage Le personnage sur lequel l'effet est appliqué.
     */
    @Override
    public void useEffect(Personnage personnage) {
        System.out.println("Capacité Pas de plume activée !");
        personnage.esquive = personnage.esquive * 2;
    }

    /**
     * Affiche les informations de la capacité Pas de plume (nom et description).
     */
    public void afficher() {
        System.out.println(this.nom + ": \n" + this.label);
    }
}
