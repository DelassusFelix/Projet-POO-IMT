package Projet_POO;

public abstract class Utilitaire {

    public String label;
    public String nom; 
    public int count; 

    public boolean isDisponible = true; 

    public Utilitaire(String label, String nom){this.label = label; this.nom = nom;}
    
    public void useEffect(Personnage personnage){}
    public void reverseEffect(Personnage personnage){}

    public String getNom(){
        return this.nom;
    }

    public String getLabel(){
        return this.label;
    }

    public int getCount(){return this.count;} 

    public void setDisponible(boolean dispo){this.isDisponible = dispo;}

    public boolean isDisponible(){return this.isDisponible;}



}
