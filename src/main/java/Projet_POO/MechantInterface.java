package Projet_POO;

public interface MechantInterface{

    public Personnage setNiveauMechant(int niveau); 

    public int getNiveau(); 

    public int getPv(); 

    public void attaque(); 

    public boolean checkAlive();

    public String getNom();
}