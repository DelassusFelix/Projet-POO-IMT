package Projet_POO;

/**
 * Interface CapaciteAffectantEnnemi.
 * Définit les comportements pour une capacité qui peut affecter un ennemi.
 * Cette capacité peut être activée et avoir un état de disponibilité.
 */
public interface CapaciteAffectantEnnemi {

    /**
     * Applique l'effet de la capacité sur un personnage ennemi.
     *
     * @param personnage Le personnage ennemi sur lequel appliquer l'effet.
     */
    public void useEffect(Personnage personnage);

    /**
     * Définit l'état de disponibilité de la capacité affectant un ennemi.
     *
     * @param dispo Un booléen indiquant si la capacité est disponible (true) ou non (false).
     */
    public void setDisponible(boolean dispo);
}
