package Projet_POO;

public class CasqueChantier extends Capacite implements CapaciteActive {

    public CasqueChantier(){
        super("Enfile ton casque ! Double ta défense pendant 3 attaques");    
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
        return this.label;
    }
}
