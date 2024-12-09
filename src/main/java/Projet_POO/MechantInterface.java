package Projet_POO;

/**
 * L'interface {@code MechantInterface} définit les méthodes nécessaires
 * pour gérer un personnage qui représente un ennemi (méchant) dans le jeu.
 * Elle permet de manipuler le niveau, les points de vie (pv), d'effectuer des
 * attaques et de vérifier l'état de vie du méchant.
 */
public interface MechantInterface {

    /**
     * Définit le niveau du méchant et met à jour ses caractéristiques
     * (points de vie, force, défense, etc.) en fonction du niveau.
     *
     * @param niveau Le niveau du méchant à définir.
     * @return Le méchant après la mise à jour de ses caractéristiques.
     */
    public Personnage setNiveauMechant(int niveau);

    /**
     * Retourne le niveau actuel du méchant.
     *
     * @return Le niveau du méchant.
     */
    public int getNiveau();

    /**
     * Retourne les points de vie actuels du méchant.
     *
     * @return Les points de vie du méchant.
     */
    public int getPv();

    /**
     * Effectue une attaque par le méchant.
     * Cette méthode est généralement utilisée pour appliquer des dégâts
     * à un personnage cible.
     */
    public void attaque();

    /**
     * Vérifie si le méchant est toujours en vie, c'est-à-dire si ses points
     * de vie sont supérieurs à zéro.
     *
     * @return {@code true} si le méchant est encore en vie, {@code false} sinon.
     */
    public boolean checkAlive();

    /**
     * Retourne le nom du méchant.
     *
     * @return Le nom du méchant.
     */
    public String getNom();
}
