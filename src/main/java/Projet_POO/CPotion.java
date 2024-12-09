package Projet_POO;

public class CPotion extends Capacite implements CapaciteActive {

    public CPotion(){
        super("Vous utilisez une potion !", "Potion de vie");
    }

    @Override
    public void useEffect(Personnage personnage){
        System.out.println("on a utilisé la capacité active potion");
        personnage.pv = personnage.pv + 30;
    }

    @Override
    public String getNom(){
        return this.label;
    }
}
