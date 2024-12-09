package Projet_POO;

public class PetitePotion extends Utilitaire implements ObjetInterface {

    public int cout = 25;

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
        personnage.pv = personnage.pv + (personnage.getPvMax() / 10);
        if (personnage.getPv() > personnage.getPvMax()) {
            personnage.setPv(personnage.getPvMax());
            System.out.println("mais vous ne pouvez pas avoir autant de pv.\n");
        }

    }

    @Override
    public int getCout(){
        return this.cout;
    }
}
