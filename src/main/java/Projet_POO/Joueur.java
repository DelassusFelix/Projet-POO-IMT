package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends Personnage {

    Utilitaire capacite;
    List<Utilitaire> objets = new ArrayList<>();
    int score;

    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom) {
        super(nom, pv, force, defense, esquive, critique);

    }

    @Override
    public String toString() {
        String data = super.toString();
        return data + "\nnom : " + nom;

    }

    public Utilitaire getCapacite() {
        return this.capacite;
    }

    public void setCapacite(Utilitaire capacite) {
        if (capacite instanceof CapaciteActiveInterface) {
            this.capacite = capacite;
        }
        if (capacite instanceof CapacitePassiveInterface) {
            this.capacite = capacite;
        }
    }

    public void utiliserCapacite(Joueur joueur) {
        this.capacite.useEffect(joueur);
    }

    public List<Utilitaire> getObjets() {
        return this.objets;
    }

    public void addObjet(Utilitaire objet) {
        if (objet instanceof ObjetInterface) {
            this.objets.add(objet);
        }
    }

    public String showObjets() {
        int count = 0;
        String res = "";
        System.out.println("\nObjets : ");
        if (this.objets.isEmpty()) {
            System.out.println("Vous n'avez pas d'objets");
            return "";
        }
        for (Utilitaire objet : objets) {
            count += 1;
            res += count + ". " + objet.nom + "\n";
        }

        return res;
    }

    public void useObjets() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel objet veux tu utiliser ?");
        int choix = scanner.nextInt();
        scanner.nextLine();
        choix = choix - 1;

        this.objets.get(choix).useEffect(this);
        this.objets.remove(choix);
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void augmenteScore(int value) {
        int score = getScore();
        score = score + value;
        setScore(score);
    }
}