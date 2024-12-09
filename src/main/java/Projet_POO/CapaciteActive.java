package Projet_POO;

/**
 * Interface CapaciteActive.
 * Représente une capacité active qui peut être appliquée à un personnage.
 */
public interface CapaciteActive {

    /**
     * Applique l'effet de la capacité active à un personnage.
     *
     * @param personnage Le personnage sur lequel appliquer l'effet.
     */
    public void useEffect(Personnage personnage);

    /**
     * Obtient le nom de la capacité active.
     *
     * @return Le nom de la capacité.
     */
    String getNom();
}
