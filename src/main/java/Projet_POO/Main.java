package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        XML xml = new XML();
        System.out.println(xml.afficherScore("Donjon Ténébreux"));


        List<String> piecesCarteImt = new ArrayList<>();
        piecesCarteImt.add("Vous arrivez sur le parking de l'IMT, prenez garde.");
        piecesCarteImt.add("Vous êtes devant l'amphi Byron, attention aux ennemis.");
        piecesCarteImt.add("Vous arrivez devant la machine à café, soyez vigilants.");
        piecesCarteImt.add("Vous y êtes, l'ultime salle des profs !");
        Carte imt = new Carte("L'IMT Nord Europe", piecesCarteImt);

        List<String> piecesCarteCrous = new ArrayList<>();
        piecesCarteCrous.add("Restez alertes, vous entrez dans le self.");
        piecesCarteCrous.add("Vous arrivez au buffet, méfiez vous.");
        piecesCarteCrous.add("Vous êtes à la plonge, gardez l'oeil.");
        piecesCarteCrous.add("Vous y êtes, voici le refectoire !");
        Carte crous = new Carte("Le CROUS ténébreux", piecesCarteCrous);

        List<String> piecesCarteBu = new ArrayList<>();
        piecesCarteBu.add("Soyez prudents, vous entrez dans la BU.");
        piecesCarteBu.add("Voici la bibliothèque, soyez sur le qui-vive.");
        piecesCarteBu.add("Vous entrez dans la salle informatique, gardez l'oeil ouvert.");
        piecesCarteBu.add("Vous y êtes, le toit de la BU !");
        Carte bibliotheque = new Carte("La BU enchantée", piecesCarteBu);

        List<Carte> cartesDispo = new ArrayList<Carte>();
        cartesDispo.add(imt);
        cartesDispo.add(crous);
        cartesDispo.add(bibliotheque);


        Potion potion = new Potion();
        GrosseEpee degat = new GrosseEpee();

        /*// mise à niveau des mechants
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

        xml.modifyXML("Donjon Ténébreux", 16000);*/


        /* a conserver dans ce commit si besoin, premiere version des capacités.
        c'était pas bien car on implémenté un joueur à une capacité.
        Donc chaque capacité aura qu'un seul joueur, ca marche mais c'est pas très élégant
        Les commentaires dans Capacite, CPotion, etc.. en font partie

        System.out.println(joueur1.toString());
        potion.setPersonnage(joueur1);
        potion.useEffect();
        System.out.println(joueur1.toString());
        */

       /* String brigand = "Brigand";
        String voleur = "Voleur";
        String catcheur = "Catcheur";

        ArrayList<String> ennemisSalle1 = new ArrayList<String>();
        ennemisSalle1.add(voleur);
        ennemisSalle1.add(voleur);

        ArrayList<String> ennemisSalle2 = new ArrayList<String>();
        ennemisSalle2.add(catcheur);
*/

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom de votre héros : ");
        String name = scanner.nextLine();

        System.out.println("\nSeléctionnez une carte : ");
        final int[] index = {1};
        cartesDispo.forEach(carte -> {
            System.out.println(index[0] + ": " + carte.getNom());
            index[0]++;
        });

        int numCarte = scanner.nextInt();
        Joueur joueur1 = new Joueur(10,10,10,50,50, name);

        Partie partie = new Partie(joueur1, cartesDispo.get(numCarte-1));
        partie.jouer();

    }
}