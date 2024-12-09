package Projet_POO;

public class LameAiguise extends Utilitaire implements CapaciteActiveInterface {

    public boolean isDisponible = true; 

    public int count = 3; 

    public LameAiguise(){
        super("Affuté.. double tes chances de critique pendant 3 attaques. Ca va piquer !", "Lame Aiguisée");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active lame aiguisée");
        personnage.critique = personnage.critique * 2; 
        // AJOUTER UN COMPTEUR, la capacité fonctionne pour 3 attaques
    }

    @Override
    public void reverseEffect(Personnage personnage){
        System.out.println("Votre lame s'est brisé ... ");
        personnage.critique = personnage.critique / 2;
    }

    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }

    @Override
    public void setDisponible(boolean dispo){
        this.isDisponible = dispo; 
    }

    @Override
    public int getCount(){
        return this.count; 
    }

}
