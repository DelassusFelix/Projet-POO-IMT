package Projet_POO;

/**
 * Classe représentant un Voleur, un type de méchant dans le jeu.
 * Le Voleur hérite des attributs et comportements de la classe Personnage
 * et implémente l'interface MechantInterface.
 */
public class Voleur extends Personnage implements MechantInterface {

    private String nom;
    private int niveau;

    /**
     * Constructeur de la classe Voleur.
     * Initialise un voleur avec les attributs de base via le constructeur de la classe Personnage.
     * Le niveau par défaut est fixé à 1.
     *
     * @param nom le nom du voleur
     */
    public Voleur(String nom){
        super(nom, 2, 2, 2, 3, 3); // Appel au constructeur de la classe Personnage
        this.nom = nom;
    }

    /**
     * Retourne le nom du voleur.
     *
     * @return le nom du voleur
     */
    @Override
    public String getNom(){
        return this.nom;
    }

    /**
     * Retourne le niveau actuel du voleur.
     *
     * @return le niveau du voleur
     */
    @Override
    public int getNiveau() {
        return niveau;
    }

    /**
     * Retourne une représentation sous forme de chaîne du voleur,
     * incluant son nom, son niveau et ses autres attributs hérités de Personnage.
     *
     * @return une chaîne décrivant le voleur
     */
    @Override
    public String toString(){
        String data = super.toString();
        return "\nnom : " + nom + "\nniv : " + niveau + data;
    }

    /**
     * Définit le niveau du voleur et met à jour ses attributs en fonction de ce niveau.
     * Cette méthode ajuste les points de vie, la force, la défense, l'esquive et les coups critiques
     * du voleur en fonction du niveau spécifié.
     *
     * @param niveau le nouveau niveau du voleur
     * @return le voleur avec ses attributs mis à jour
     */
    @Override
    public Voleur setNiveauMechant(int niveau){
        this.niveau = niveau;
        this.pvMax = 20 * niveau;
        this.pv = this.pvMax;
        this.force = 4 * niveau;
        this.defense = (float) (0.25 * niveau);
        this.esquive = 7 * niveau;
        this.critique = 12 * niveau;

        Voleur voleur = new Voleur("voleur");

        return voleur;
    }

    /**
     * Méthode d'attaque vide pour le Voleur. Cette méthode doit être étendue
     * dans une version future pour implémenter le comportement spécifique d'attaque.
     */
    @Override
    public void attaque() {}
}
