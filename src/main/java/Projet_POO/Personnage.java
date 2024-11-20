

public class Personnage{
    int pv;
    int force;
    float defense;
    int esquive; 
    int critique; 
    boolean isDead = false; 

    public Personnage(int pv, int force, float defense, int esquive, int critique){
        this.pv = pv;
        this.force = force;
        this.defense = defense;
        this.esquive = esquive;
        this.critique = critique; 
    }

    @Override
    public String toString(){
        return "\npv : " + this.pv + 
                "\nforce : " + this.force + 
                "\ndef : " + this.defense +
                "\nesquive : " + this.esquive +
                "\ncritique : " + this.critique;
    }

    public int getPv(){
        return this.pv;
    }

    public void setPv(int pv){
        this.pv = pv; 
    }

    public int getForce(){
        return this.force;
    }

    public void setForce(int force){
        this.force = force; 
    }

    public float getDefense(){
        return this.defense;
    }

    public void setDefense(int defense){
        this.defense = defense; 
    }

    public int getEsquive(){
        return this.esquive;
    }

    public void setEsquive(int esquive){
        this.esquive = esquive; 
    }

    public int getCritique(){
        return this.esquive;
    }

    public void setCritique(int critique){
        this.critique = critique; 
    }

    public boolean isDead(){
        if (isDead){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAlive(){
        if (this.getPv() <= 0){
            return false;
        } else {
            return true; 
        }
    }

    public void setDead(){
        this.isDead=true;
    }

    public void attaque(Personnage defenseur){

        float degat = 0;
        int randomIntCrit = (int) (Math.random() * 101);

        if (this.getCritique() > randomIntCrit ){
            
            degat = ((this.getForce() * 2) / defenseur.getDefense());
            degat = Math.round(degat);
            System.out.println("c'est un coup critique ! " + degat); 
        } else {
            degat = this.getForce() / defenseur.getDefense();
            degat = Math.round(degat);
            System.out.println("il inflige " + degat + " degats ! ");
        }

        float nouveauPV = defenseur.getPv() - degat; 
        int nouveauPVint = Math.round(nouveauPV); 

        int randomIntEsqu = (int) (Math.random() * 101);

        if (defenseur.getEsquive() > randomIntEsqu ){
            System.out.println( " esquive !! "); 
        } else {
            defenseur.setPv( nouveauPVint );
        }
        
    }

    



}
