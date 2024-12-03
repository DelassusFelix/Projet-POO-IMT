package Projet_POO;

public class Personnage {
    String nom;
    int pv; // Points de vie actuels
    int pvMax; // Points de vie maximums
    int force;
    float defense;
    int esquive;
    int critique;
    boolean isDead = false;

    public Personnage(String nom, int pv, int force, float defense, int esquive, int critique) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv; // Initialisation des PV maximums à la création
        this.force = force;
        this.defense = defense;
        this.esquive = esquive;
        this.critique = critique;
    }

    @Override
    public String toString() {
        return "\npv : " + this.pv + "/" + this.pvMax + // Ajout des PV maximums
                "\nforce : " + this.force +
                "\ndef : " + this.defense +
                "\nesquive : " + this.esquive +
                "\ncritique : " + this.critique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return this.pv;
    }

    public void setPv(int pv) {
        if (pv > this.pvMax) {
            this.pv = this.pvMax; // Limite aux PV maximums
        } else if (pv < 0) {
            this.pv = 0; // Empêche les PV négatifs
        } else {
            this.pv = pv;
        }
    }


    public int getPvMax() {
        return this.pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
        if (this.pv > pvMax) {
            this.pv = pvMax; // Ajuste les PV actuels si les PV max sont réduits
        }
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public float getDefense() {
        return this.defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public int getEsquive() {
        return this.esquive;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public int getCritique() {
        return this.critique;
    }

    public void setCritique(int critique) {
        this.critique = critique;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public boolean checkAlive() {
        return this.pv > 0;
    }

    public void setDead() {
        this.isDead = true;
    }

    public void attaque(Personnage defenseur) {
        float degat = 0;
        int randomIntCrit = (int) (Math.random() * 101);

        // Vérification si c'est un coup critique
        if (this.getCritique() > randomIntCrit) {
            degat = ((this.getForce() * 2) / defenseur.getDefense());
            degat = Math.round(degat);
            System.out.println("C'est un coup critique de " + (this instanceof Joueur ? "vous" : this.getNom()) + " ! " + degat + " dégâts infligés !");
        } else {
            degat = this.getForce() / defenseur.getDefense();
            degat = Math.round(degat);
            System.out.println((this instanceof Joueur ? "Vous" : this.getNom()) + " inflige " + degat + " dégâts !");
        }

        // Vérification de l'esquive
        int randomIntEsqu = (int) (Math.random() * 101);
        if (defenseur.getEsquive() > randomIntEsqu) {
            System.out.println("Esquive réussie !");
        } else {
            // Appliquer les dégâts si l'esquive échoue
            float nouveauPV = defenseur.getPv() - degat;
            defenseur.setPv(Math.round(nouveauPV));
        }
    }

}
