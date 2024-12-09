package Projet_POO;

public class Potion extends Utilitaire implements CapaciteActiveInterface {

    public boolean isDisponible = true; 

    public int count = 1; 

    public Potion(){
        super("Une grande soife contre les grands dégats. Restaure 30 PV", "Potion");
    }

    /* 
    @Override
    public void useEffect(){
        Personnage perso = this.getPersonnage();
        perso.pv = perso.pv + 10; 
    }
    */

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active potion");
        personnage.pv = personnage.pv + 30;
        if (personnage.pv > 100 ){
            personnage.pv = 100; 
        }
    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo; 
    }

    @Override
    public int getCount(){
        return this.count; 
    }
}
