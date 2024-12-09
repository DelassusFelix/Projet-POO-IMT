package Projet_POO;

/**
 * Classe Brigand représentant un ennemi de type brigand.
 * Hérite de la classe Personnage et implémente l'interface MechantInterface.
 */
public class Brigand extends Personnage implements MechantInterface {

    /** Nom du brigand. */
    String nom;

    /** Niveau du brigand. */
    int niveau;

    /**
     * Constructeur de la classe Brigand.
     * Initialise un brigand avec un nom, des points de vie, force, défense, esquive, et critique par défaut.
     *
     * @param nom Nom du brigand.
     */
    public Brigand(String nom) {
        super(nom, 3, 3, 2, 2, 2);
        this.nom = nom;
    }

    /**
     * Obtient le nom du brigand.
     *
     * @return Le nom du brigand.
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    /**
     * Obtient le niveau actuel du brigand.
     *
     * @return Le niveau du brigand.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Retourne une représentation textuelle des informations du brigand.
     *
     * @return Une chaîne de caractères contenant le nom, le niveau, et les attributs hérités du personnage.
     */
    @Override
    public String toString() {
        String data = super.toString();
        return "\nnom : " + nom + "\nniv : " + niveau + data;
    }

    /**
     * Définit le niveau du brigand en ajustant ses attributs en conséquence.
     *
     * @param niveau Le niveau à attribuer au brigand.
     * @return Une instance de Brigand mise à jour.
     */
    @Override
    public Brigand setNiveauMechant(int niveau) {
        this.niveau = niveau;
        this.pvMax = 30 * niveau;
        this.pv = this.pvMax;
        this.force = 5 * niveau;
        this.defense = (float) (0.3 * niveau);
        this.esquive = 3 * niveau;
        this.critique = 4 * niveau;

        Brigand brigand = new Brigand("brigand");

        return brigand;
    }

    /**
     * Implémentation vide de la méthode attaque.
     * Doit être remplie selon les spécifications du comportement d'attaque.
     */
    @Override
    public void attaque() {}

}
