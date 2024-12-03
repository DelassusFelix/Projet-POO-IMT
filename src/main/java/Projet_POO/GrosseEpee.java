package Projet_POO;

public class GrosseEpee extends Capacite implements CapacitePassive {

    public GrosseEpee(){
        super("Ooooh yeah. Une mega épée pour des mégas dégats. Double tes dégats pendant toute la partie");
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
        System.out.println("on a utilisé la capacite passive grosse épée");
        personnage.force = personnage.force * 2; 

    }
}
