package Projet_POO;

public class CasqueChantier extends Capacite implements CapaciteActive {

    public CasqueChantier(){
        super("Enfile ton casque ! Double ta défense pendant 3 attaques");    
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active casque de chantier");
        personnage.defense = personnage.defense * 2; 
        // AJOUTER UN COMPTEUR, la capacité fonctionne pour 3 attaques

    }
}
