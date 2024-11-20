package Projet_POO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String brigand = "Brigand";
        String voleur = "Voleur";
        String catcheur = "Catcheur";

        ArrayList<String> ennemisSalle1 = new ArrayList<String>();
        ennemisSalle1.add(voleur);
        ennemisSalle1.add(voleur);

        ArrayList<String> ennemisSalle2 = new ArrayList<String>();
        ennemisSalle2.add(catcheur);

        Voleur voleur1 = new Voleur("Victor");

        Brigand brigand1 = new Brigand("Bruno");

        Catcheur catcheur1 = new Catcheur("Charly");

        voleur1.setNiveauMechant(10);
        brigand1.setNiveauMechant(10);
        catcheur1.setNiveauMechant(10);

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


    }
}