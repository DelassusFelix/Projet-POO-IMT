package Projet_POO;

public class PasDePlume extends Utilitaire implements CapacitePassiveInterface {

    public PasDePlume(){
        super("Agile Bill.. te voila leger comme l'air. Tu doubles ta capacité d'esquive", "Pas de plume"); 
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("Capacité Pas de plume activée !");
        personnage.esquive = personnage.esquive * 2; 

    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
