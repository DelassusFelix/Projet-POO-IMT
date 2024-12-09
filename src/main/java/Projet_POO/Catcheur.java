package Projet_POO;

/**
 * Classe Catcheur.
 * Représente un personnage de type "Catcheur" dans le jeu.
 * Hérite de la classe Personnage et implémente l'interface MechantInterface.
 * Le catcheur possède des statistiques basées sur un niveau qui peut être modifié.
 */
public class Catcheur extends Personnage implements MechantInterface {

    /** Nom du catcheur. */
    String nom;

    /** Niveau du catcheur, influence ses statistiques. */
    int niveau;

    /**
     * Constructeur de Catcheur.
     * Initialise un catcheur avec des valeurs de base et un nom.
     *
     * @param nom Le nom du catcheur.
     */
    public Catcheur(String nom){
        super(nom, 3, 2, 3, 2, 2);
        this.nom = nom;
    }

    /**
     * Obtient le nom du catcheur.
     *
     * @return Le nom du catcheur.
     */
    @Override
    public String getNom(){
        return this.nom;
    }

    /**
     * Obtient le niveau actuel du catcheur.
     *
     * @return Le niveau du catcheur.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Représente une chaîne de caractères décrivant les caractéristiques du catcheur.
     * Inclut le nom, le niveau, et les statistiques de base du catcheur.
     *
     * @return Une chaîne formatée représentant le catcheur.
     */
    @Override
    public String toString(){
        String data = super.toString();
        return "\nnom : " + nom + "\nniv : " + niveau + data;
    }

    /**
     * Met à jour les statistiques du catcheur en fonction de son niveau.
     * Cette méthode ajuste la santé, la force, la défense, l'esquive, et le taux de critique.
     *
     * @param niveau Le niveau du catcheur à définir.
     * @return Le catcheur mis à jour avec ses nouvelles statistiques.
     */
    @Override
    public Catcheur setNiveauMechant(int niveau){
        this.niveau = niveau;
        this.pvMax = 35 * niveau;
        this.pv = this.pvMax;
        this.force = 6 * niveau;
        this.defense = (float) (0.5 * niveau);
        this.esquive = 3 * niveau;
        this.critique = 5 * niveau;

        Catcheur catcheur = new Catcheur("voleur");

        return catcheur;
    }

    /**
     * Méthode d'attaque, non implémentée dans cette classe.
     * Cette méthode doit être définie par une classe enfant ou implémentée spécifiquement.
     */
    @Override
    public void attaque(){}

}
