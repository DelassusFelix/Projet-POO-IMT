package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        XML xml = new XML();

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



        // Scanner pour interaction utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande le nom du héros
        System.out.println("Entrez le nom de votre héros : ");
        String name = scanner.nextLine();

        // Sélection de la carte
        System.out.println("\nSélectionnez une carte : ");
        final int[] index = {1};
        cartesDispo.forEach(carte -> {
            System.out.println(index[0] + ": " + carte.getNom());
            index[0]++;
        });

        int numCarte = scanner.nextInt();
        Carte carteChoisie = cartesDispo.get(numCarte - 1);

        // Création du joueur
        Joueur joueur1 = new Joueur(10, 10, 10, 50, 50, name);

        // Choisir une capacité
        Utilitaire capaciteChoisie = ChoisirLaCapacites();
        if (capaciteChoisie != null) {
            joueur1.setCapacite(capaciteChoisie); // Ajout de la capacité au joueur
        }

        // Démarrer une partie
        Partie partie = new Partie(joueur1, carteChoisie);
        partie.jouer();
    }

    public static Utilitaire ChoisirLaCapacites() {
        List<CapaciteActiveInterface> ListeCapacitesActives = new ArrayList<>();
        List<CapacitePassiveInterface> ListeCapacitesPassives = new ArrayList<>();

        // Création des instances des capacités
        CasqueChantier casqueChantier = new CasqueChantier();
        CocktailMolotov cocktailMolotov = new CocktailMolotov();
        GilletParBalle gilletParBalle = new GilletParBalle();
        GrosseEpee grosseEpee = new GrosseEpee();
        LameAiguise lameAiguise = new LameAiguise();
        PasDePlume pasDePlume = new PasDePlume();
        Potion potion = new Potion();

        // Ajout des capacités à leurs listes respectives
        ListeCapacitesActives.add(casqueChantier);
        ListeCapacitesActives.add(cocktailMolotov);
        ListeCapacitesActives.add(lameAiguise);
        ListeCapacitesActives.add(potion);

        ListeCapacitesPassives.add(gilletParBalle);
        ListeCapacitesPassives.add(grosseEpee);
        ListeCapacitesPassives.add(pasDePlume);

        // Affichage des capacités
        System.out.println("\n=== Capacités Actives ===");
        int id = 1;
        for (CapaciteActiveInterface capacite : ListeCapacitesActives) {
            System.out.println(id++ + ". " + capacite.getNom() + " - " + capacite.getLabel());
        }

        System.out.println("\n=== Capacités Passives ===");
        for (CapacitePassiveInterface capacite : ListeCapacitesPassives) {
            System.out.println(id++ + ". " + capacite.getNom() + " - " + capacite.getLabel());
        }

        // Demander à l'utilisateur de faire un choix
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEntrez le numéro de la capacité que vous souhaitez sélectionner : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        // Valider le choix et retourner l'objet correspondant
        if (choix > 0 && choix <= ListeCapacitesActives.size()) {
            CapaciteActiveInterface capaciteChoisie = ListeCapacitesActives.get(choix - 1);
            System.out.println("Vous avez sélectionné l'active : " + capaciteChoisie.getNom());
            return (Utilitaire) capaciteChoisie;
        } else if (choix > ListeCapacitesActives.size() && choix <= ListeCapacitesActives.size() + ListeCapacitesPassives.size()) {
            CapacitePassiveInterface capaciteChoisie = ListeCapacitesPassives.get(choix - ListeCapacitesActives.size() - 1);
            System.out.println("Vous avez sélectionné la passive : " + capaciteChoisie.getNom());
            return (Utilitaire) capaciteChoisie;
        } else {
            System.out.println("Choix invalide, aucune capacité sélectionnée.");
            return null;
        }
    }
}