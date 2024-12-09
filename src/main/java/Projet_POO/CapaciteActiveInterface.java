package Projet_POO;

/**
 * Interface CapaciteActiveInterface.
 * Définit les comportements pour une capacité active qui peut être appliquée à un personnage.
 * Une capacité active peut également avoir un état de disponibilité.
 */
public interface CapaciteActiveInterface {

    /**
     * Applique l'effet de la capacité active à un personnage.
     *
     * @param personnage Le personnage sur lequel appliquer l'effet.
     */
    public void useEffect(Personnage personnage);

    /**
     * Obtient le nom de la capacité active.
     *
     * @return Le nom de la capacité active.
     */
    public String getNom();

    /**
     * Obtient l'étiquette ou la description de la capacité active.
     *
     * @return La description ou l'étiquette de la capacité active.
     */
    public String getLabel();

    /**
     * Définit l'état de disponibilité de la capacité active.
     *
     * @param dispo Un booléen indiquant si la capacité est disponible (true) ou non (false).
     */
    public void setDisponible(boolean dispo);
}
