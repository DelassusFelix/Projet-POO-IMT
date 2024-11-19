public abstract class Personnage{
    int pv;
    int force;
    int defense;
    int esquive; 

    public Personnage(int pv, int force, int defense, int esquive){
        this.pv=pv;
        this.force=force;
        this.defense=defense;
        this.esquive=esquive;
    }

    @Override
    public String toString(){
        return "pv : " + this.pv + 
                "\nforce : " + this.force + 
                "\ndef : " + this.defense +
                "\nesquive : " + this.esquive; 
    }



}
