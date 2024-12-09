package Projet_POO;

public class LameAiguise extends Utilitaire implements CapaciteActiveInterface {

    public LameAiguise() {
        super("Affuté.. double tes chances de critique pendant 3 attaques. Ca va piquer !", "Lame Aiguisée");
    }

    @Override
    public void useEffect(Personnage personnage) {
        System.out.println("on a utilisé la capacité active lame aiguisée");
        personnage.critique = personnage.critique * 2;
        // AJOUTER UN COMPTEUR, la capacité fonctionne pour 3 attaques
    }

    @Override
    public String getNom() {
        return this.label;
    }

    @Override
    public String getLabel(){
        return this.label;
    }

    public void afficher() {
        System.out.println(this.nom + ": \n" + this.label);
    }

}
