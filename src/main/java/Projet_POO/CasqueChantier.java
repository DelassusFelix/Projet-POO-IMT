package Projet_POO;

public class CasqueChantier extends Utilitaire implements CapaciteActiveInterface {

    public CasqueChantier(){
        super("Enfile ton casque ! Double ta défense pendant 3 attaques", "Casque de Chantier");    
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("Vous enfilez votre casque de chantier ! Défense x2 pendant 3 tours.");
        personnage.defense = personnage.defense * 2;
    }

    @Override
    public void reverseEffect(Personnage personnage){
        System.out.println("Votre casque de chantier est brisé ... ");
        personnage.defense = personnage.defense / 2;
    }

    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
    public String getLabel(){
        return this.label;
    }
    
    public void afficher(){
        System.out.println(this.nom + ": \n" + this.label);
    }
}
