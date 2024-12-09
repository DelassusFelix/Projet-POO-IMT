package Projet_POO;

public abstract class Capacite {

    public String label;

    public Capacite(String label){this.label = label;}
    
    public void useEffect(Personnage personnage){}
    public void reverseEffect(Personnage personnage){}

}
