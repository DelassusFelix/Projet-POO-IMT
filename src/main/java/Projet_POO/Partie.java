package Projet_POO;

import java.util.ArrayList;
import java.util.Date;

public class Partie {
    Date dateDebut, dateFin;
    boolean gameOver, enCours;
    ArrayList<Carte> cartes;

    public Partie(Date dateDebut, boolean gameOver, boolean enCours, ArrayList<Carte> cartes) {
        this.dateDebut = dateDebut;
        this.gameOver = gameOver;
        this.enCours = enCours;
        this.cartes = cartes;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isEnCours() {
        return enCours;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    public ArrayList getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList cartes) {
        this.cartes = cartes;
    }

    
}
