package Projet_POO;

public class GilletParBalle extends Utilitaire implements CapacitePassiveInterface {

    public GilletParBalle(){
        super("Pas de place aux doutes. Mets ton gilet, sois fort et gagne 1 point de défense ", "Gillet par Balle");
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

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
