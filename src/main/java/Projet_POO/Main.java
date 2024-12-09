package Projet_POO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Logger logger = new Logger("Partie");
        XML xml = new XML();

        List<String> piecesCarteImt = new ArrayList<>();
        piecesCarteImt.add("Vous arrivez sur le parking de l'IMT, prenez garde.");
        piecesCarteImt.add("Vous êtes devant l'amphi Byron, attention aux ennemis.");
        piecesCarteImt.add("Vous arrivez devant la machine à café, soyez vigilants.");
        piecesCarteImt.add("Vous y êtes, l'ultime salle des profs !");
        Carte imt = new Carte("L'IMT Nord Horror", piecesCarteImt);

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

        Scanner scanner = new Scanner(System.in);

        logger.log("\n" +
                "██╗███╗   ███╗████████╗    ████████╗██╗  ██╗███████╗███╗   ███╗     █████╗ ██╗     ██╗     \n" +
                "██║████╗ ████║╚══██╔══╝    ╚══██╔══╝██║  ██║██╔════╝████╗ ████║    ██╔══██╗██║     ██║     \n" +
                "██║██╔████╔██║   ██║          ██║   ███████║█████╗  ██╔████╔██║    ███████║██║     ██║     \n" +
                "██║██║╚██╔╝██║   ██║          ██║   ██╔══██║██╔══╝  ██║╚██╔╝██║    ██╔══██║██║     ██║     \n" +
                "██║██║ ╚═╝ ██║   ██║          ██║   ██║  ██║███████╗██║ ╚═╝ ██║    ██║  ██║███████╗███████╗\n" +
                "╚═╝╚═╝     ╚═╝   ╚═╝          ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝    ╚═╝  ╚═╝╚══════╝╚══════╝\n");

        logger.log("Bienvenue jeune aventurier !");

        logger.log("\nComment vous appellez vous ? : ");
        String name = scanner.nextLine();

        logger.log("\nSeléctionnez une carte : ");
        final int[] index = {1};
        cartesDispo.forEach(carte -> {
            System.out.println(index[0] + ": " + carte.getNom());
            index[0]++;
        });

        int numCarte = scanner.nextInt();
        System.out.println(xml.afficherScore(cartesDispo.get(numCarte-1)));
        scanner.nextLine();

        Joueur joueur1 = new Joueur(100,10,10,50,50, name);
        ChoisirLaCapacite(joueur1, logger);

        Partie partie = new Partie(joueur1, cartesDispo.get(numCarte-1));
        partie.jouer();

    }

    public static void ChoisirLaCapacite(Joueur joueur, Logger logger) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Utilitaire> ListeCapacitesActive = new ArrayList<>();
        List<Utilitaire> ListeCapacitesPassives = new ArrayList<>();

        CasqueChantier casqueChantier = new CasqueChantier();
        CocktailMolotov cocktailMolotov = new CocktailMolotov();
        GilletParBalle gilletParBalle = new GilletParBalle();
        GrosseEpee grosseEpee = new GrosseEpee(); 
        LameAiguise lameAiguise = new LameAiguise();
        PasDePlume pasDePlume = new PasDePlume();
        Potion potion = new Potion(); 

        ListeCapacitesActive.add(casqueChantier);
        ListeCapacitesActive.add(cocktailMolotov);
        ListeCapacitesActive.add(lameAiguise);
        ListeCapacitesActive.add(potion); 

        ListeCapacitesPassives.add(gilletParBalle);
        ListeCapacitesPassives.add(grosseEpee);
        ListeCapacitesPassives.add(pasDePlume);

        scanner.nextLine();
        int indice=1; 
        logger.log("== Capacité actives ==");
        for (Utilitaire capacite : ListeCapacitesActive){
            logger.log(indice + ". " + capacite.getNom() + " - " + capacite.getLabel());
            indice += 1;
        }

        logger.log("\n== Capacité passives ==");
        for (Utilitaire capacite : ListeCapacitesPassives){
            logger.log(indice + ". " + capacite.getNom() + " - " + capacite.getLabel());
            indice += 1;
        }
        logger.log("\nQuelle capacité souhaitez vous prendre : ");
        logger.log(">");
        int numCapacite = scanner.nextInt();

        if (numCapacite > 0 && numCapacite <= ListeCapacitesActive.size()){
            Utilitaire capaciteChoisie = ListeCapacitesActive.get(numCapacite - 1);
            logger.log("Vous avez choisi la capacité active : " + capaciteChoisie.getNom());
            joueur.setCapacite(capaciteChoisie);
        } else if ( 
            numCapacite > ListeCapacitesActive.size() &&
            numCapacite <= ListeCapacitesActive.size() + ListeCapacitesPassives.size()
            ) {
            Utilitaire capaciteChoisie = ListeCapacitesPassives.get(numCapacite - ListeCapacitesActive.size() - 1);
            logger.log("Vous avez choisi la capacité passive : " + capaciteChoisie.getNom());
            joueur.setCapacite(capaciteChoisie);
            joueur.capacite.useEffect(joueur);
        } else {
            logger.log("Choix de capacité invalide");
        }  

    }
}