package Projet_POO;

public class GilletParBalle extends Capacite implements CapacitePassive {

    public GilletParBalle(){
        super("Pas de place aux doutes. Mets ton gilet, sois fort et gagne 1 point de défense ");
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
        System.out.println("on a utilisé la capacite passive Gillet par Balles");
        personnage.defense = personnage.defense + 1; 

    }
}
