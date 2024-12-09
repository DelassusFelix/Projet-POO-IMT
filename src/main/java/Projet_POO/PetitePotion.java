package Projet_POO;

public class PetitePotion extends Utilitaire implements ObjetInterface {

    public int cout = 10; 

    public PetitePotion(){
        super("", "Petite potion");
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
        System.out.println("on a utilisé l'objet petite potion\n");
        personnage.pv = personnage.pv + 2; 
        if (personnage.getPv() > 10) {
            personnage.setPv(10);
            System.out.println("mais vous ne pouvez pas avoir plus de 10 PV.\n");
        }

    }

    @Override
    public int getCout(){
        return this.cout;
    }
}
