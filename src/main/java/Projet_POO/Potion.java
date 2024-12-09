package Projet_POO;

public class Potion extends Utilitaire implements CapaciteActiveInterface {

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
    }

    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
    public String getLabel() { return this.label;}

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
