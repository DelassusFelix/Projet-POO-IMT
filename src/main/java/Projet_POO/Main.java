package Projet_POO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        XML xml = new XML();
        System.out.println(xml.afficherScore("Donjon Ténébreux"));

        CPotion potion = new CPotion();
        CGrosseEpee degat = new CGrosseEpee();

        Voleur voleur1 = new Voleur("Victor");

        Brigand brigand1 = new Brigand("Bruno");

        Catcheur catcheur1 = new Catcheur("Charly");

        Joueur joueur1 = new Joueur(100,10,10,50,50,"Jack");

        // mise à niveau des mechants
        voleur1.setNiveauMechant(10);
        brigand1.setNiveauMechant(10);
        catcheur1.setNiveauMechant(10);

        // test des capacités
        System.out.println(joueur1.toString());
        joueur1.setCapacite(potion);
        joueur1.capacite.useEffect(joueur1);
        System.out.println(joueur1.toString());

        System.out.println(joueur1.toString());
        joueur1.setCapacite(degat);
        joueur1.capacite.useEffect(joueur1);
        System.out.println(joueur1.toString());

        xml.modifyXML("Donjon Ténébreux", 16000);





        /* a conserver dans ce commit si besoin, premiere version des capacités.
        c'était pas bien car on implémenté un joueur à une capacité.
        Donc chaque capacité aura qu'un seul joueur, ca marche mais c'est pas très élégant
        Les commentaires dans Capacite, CPotion, etc.. en font partie

        System.out.println(joueur1.toString());
        potion.setPersonnage(joueur1);
        potion.useEffect();
        System.out.println(joueur1.toString());
        */

        String brigand = "Brigand";
        String voleur = "Voleur";
        String catcheur = "Catcheur";

        ArrayList<String> ennemisSalle1 = new ArrayList<String>();
        ennemisSalle1.add(voleur);
        ennemisSalle1.add(voleur);

        ArrayList<String> ennemisSalle2 = new ArrayList<String>();
        ennemisSalle2.add(catcheur);


        /* trace de combat

        while( voleur1.checkAlive() && brigand1.checkAlive()){
            System.out.println(
                "\n"+ voleur1.getNom() +
                "\npv : " + voleur1.getPv() +
                "\n"+ brigand1.getNom() +
                "\npv : " + brigand1.getPv());
            voleur1.attaque(brigand1);
            System.out.println(
                "\n"+ voleur1.getNom() +
                "\npv : " + voleur1.getPv() +
                "\n"+ brigand1.getNom() +
                "\npv : " + brigand1.getPv());
            brigand1.attaque(voleur1);
        }
            */





    }
}