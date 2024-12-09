package Projet_POO;

public class CGrosseEpee extends Capacite implements CapacitePassive {

    public CGrosseEpee(){
        super("Voici une meilleure épée !", "Grosse épée");

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
