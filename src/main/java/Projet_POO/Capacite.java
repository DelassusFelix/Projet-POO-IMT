package Projet_POO;

public abstract class Capacite {

    public String nom;
    public String label;

    public Capacite(String label, String nom) {
        this.label = label;
        this.nom = nom;
    }

    public void useEffect(Personnage personnage) {
    }

    public void reverseEffect(Personnage personnage) {
    }

}
