package Projet_POO;

public class LameAiguise extends Capacite implements CapaciteActive {

    public LameAiguise(){
        super("Affuté.. double tes chances de critique pendant 3 attaques. Ca va piquer !");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active lame aiguisée");
        personnage.critique = personnage.critique * 2; 
        // AJOUTER UN COMPTEUR, la capacité fonctionne pour 3 attaques

    }
}
