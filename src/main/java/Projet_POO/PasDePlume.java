package Projet_POO;

public class PasDePlume extends Utilitaire implements CapacitePassiveInterface {

    public PasDePlume(){
        super("Agile bill, te voila leger comme l'air. Tu doubles ta capacité d'esquive", "Pas de plume"); 
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacite passive pas de plume");
        personnage.esquive = personnage.esquive * 2; 

    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    @Override
    public String getLabel(){
        return this.label;
    }

    @Override
    public String getNom(){
        return this.nom;
    }
}
