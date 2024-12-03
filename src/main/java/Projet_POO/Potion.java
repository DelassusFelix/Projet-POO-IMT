package Projet_POO;

public class Potion extends Capacite implements CapaciteActive {

    public Potion(){
        super("Une grande soife contre les grands dégats. Restaure 30 PV");
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

    }
}
