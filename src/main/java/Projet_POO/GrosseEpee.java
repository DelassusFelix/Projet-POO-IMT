package Projet_POO;

public class GrosseEpee extends Utilitaire implements CapacitePassiveInterface {

    public GrosseEpee(){
        super("Voici une meilleure épée !", "Grosse Epée");

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

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    @Override
    public String getNom(){
        return this.nom;
    };

    @Override
    public String getLabel(){
        return this.label;
    }
}
