package Projet_POO;

public abstract class Utilitaire {

    public String label;
    public String nom; 

    public Utilitaire(String label, String nom){this.label = label; this.nom = nom;}
    
    public void useEffect(Personnage personnage){}
    public void reverseEffect(Personnage personnage){}

}
