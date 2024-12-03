package Projet_POO;

public class PasDePlume extends Capacite implements CapacitePassive {

    public PasDePlume(){
        super("Agile bill, te voila leger comme l'air. Tu doubles ta capacité d'esquive"); 
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
        System.out.println("on a utilisé la capacite passive pas de plume");
        personnage.esquive = personnage.esquive * 2; 

    }
}
