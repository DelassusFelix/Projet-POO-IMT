package Projet_POO;

/**
 * Classe abstraite représentant un objet utilitaire dans le jeu.
 * Les objets utilitaires peuvent avoir des effets sur le personnage et peuvent être utilisés dans le jeu.
 */
public abstract class Utilitaire {

    /**
     * La description ou le label de l'objet utilitaire.
     */
    public String label;

    /**
     * Le nom de l'objet utilitaire.
     */
    public String nom;

    /**
     * Le nombre d'utilisations restantes ou le nombre d'objets.
     */
    public int count;

    /**
     * Indique si l'objet est actuellement disponible pour être utilisé.
     */
    public boolean isDisponible = true;

    /**
     * Constructeur de la classe Utilitaire.
     * Initialise l'objet utilitaire avec un label et un nom.
     *
     * @param label La description de l'objet utilitaire.
     * @param nom Le nom de l'objet utilitaire.
     */
    public Utilitaire(String label, String nom) {
        this.label = label;
        this.nom = nom;
    }

    /**
     * Applique l'effet de l'objet utilitaire au personnage.
     * Cette méthode est à implémenter dans les sous-classes qui définissent un effet spécifique.
     *
     * @param personnage Le personnage sur lequel l'effet sera appliqué.
     */
    public void useEffect(Personnage personnage) {}

    /**
     * Inverse l'effet de l'objet utilitaire sur le personnage.
     * Cette méthode est à implémenter dans les sous-classes qui définissent un effet inversé.
     *
     * @param personnage Le personnage sur lequel l'effet inversé sera appliqué.
     */
    public void reverseEffect(Personnage personnage) {}

    /**
     * Retourne le nom de l'objet utilitaire.
     *
     * @return Le nom de l'objet utilitaire.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne la description ou le label de l'objet utilitaire.
     *
     * @return La description de l'objet utilitaire.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Retourne le nombre d'utilisations restantes de l'objet.
     *
     * @return Le nombre d'utilisations restantes.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Définit la disponibilité de l'objet utilitaire.
     *
     * @param dispo Vrai si l'objet est disponible, faux sinon.
     */
    public void setDisponible(boolean dispo) {
        this.isDisponible = dispo;
    }

    /**
     * Vérifie si l'objet utilitaire est disponible pour être utilisé.
     *
     * @return Vrai si l'objet est disponible, faux sinon.
     */
    public boolean isDisponible() {
        return this.isDisponible;
    }
}
