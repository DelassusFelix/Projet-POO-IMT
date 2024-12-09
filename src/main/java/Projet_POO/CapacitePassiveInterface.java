package Projet_POO;

/**
 * Interface CapacitePassiveInterface.
 * Définit les comportements pour une capacité passive qui peut être appliquée à un personnage.
 * Les capacités passives ne nécessitent pas d'activation directe mais influencent les caractéristiques d'un personnage en permanence.
 */
public interface CapacitePassiveInterface {

    /**
     * Obtient le nom de la capacité passive.
     *
     * @return Le nom de la capacité passive.
     */
    public String getNom();

    /**
     * Obtient l'étiquette ou la description de la capacité passive.
     *
     * @return La description ou l'étiquette de la capacité passive.
     */
    public String getLabel();
}
