package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Joueur représentant un personnage contrôlé par le joueur.
 * Hérite de la classe Personnage et inclut des fonctionnalités spécifiques aux joueurs
 * telles que la gestion des capacités, des objets et du score.
 */
public class Joueur extends Personnage {

    /**
     * Capacité spéciale du joueur (active ou passive).
     */
    Utilitaire capacite;

    /**
     * Liste des objets possédés par le joueur.
     */
    List<Utilitaire> objets = new ArrayList<>();

    /**
     * Score du joueur.
     */
    int score;

    /**
     * Constructeur de la classe Joueur.
     *
     * @param pv       Points de vie initiaux du joueur.
     * @param force    Force du joueur.
     * @param defense  Défense du joueur.
     * @param esquive  Esquive du joueur.
     * @param critique Critique du joueur.
     * @param nom      Nom du joueur.
     */
    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom) {
        super(nom, pv, force, defense, esquive, critique);
    }

    /**
     * Renvoie une représentation textuelle des statistiques du joueur, incluant le nom.
     *
     * @return Une chaîne de caractères contenant les statistiques et le nom du joueur.
     */
    @Override
    public String toString() {
        String data = super.toString();
        return data + "\nnom : " + nom;
    }

    /**
     * Retourne la capacité actuelle du joueur.
     *
     * @return L'objet Utilitaire représentant la capacité du joueur.
     */
    public Utilitaire getCapacite() {
        return this.capacite;
    }

    /**
     * Définit la capacité spéciale du joueur (active ou passive).
     *
     * @param capacite L'objet Utilitaire représentant la nouvelle capacité.
     */
    public void setCapacite(Utilitaire capacite) {
        if (capacite instanceof CapaciteActiveInterface) {
            this.capacite = capacite;
        }
        if (capacite instanceof CapacitePassiveInterface) {
            this.capacite = capacite;
        }
    }

    /**
     * Utilise la capacité spéciale du joueur sur un autre joueur.
     *
     * @param joueur Le joueur sur lequel appliquer la capacité.
     */
    public void utiliserCapacite(Joueur joueur) {
        this.capacite.useEffect(joueur);
    }

    /**
     * Retourne la liste des objets possédés par le joueur.
     *
     * @return Une liste d'objets Utilitaire.
     */
    public List<Utilitaire> getObjets() {
        return this.objets;
    }

    /**
     * Ajoute un objet à l'inventaire du joueur, si cet objet implémente ObjetInterface.
     *
     * @param objet L'objet à ajouter.
     */
    public void addObjet(Utilitaire objet) {
        if (objet instanceof ObjetInterface) {
            this.objets.add(objet);
        }
    }

    /**
     * Affiche les objets disponibles dans l'inventaire du joueur.
     *
     * @return Une chaîne contenant la liste des objets et leurs numéros.
     */
    public String showObjets() {
        int count = 0;
        String res = "";
        System.out.println("\nObjets :");
        if (this.objets.isEmpty()) {
            System.out.println("Vous n'avez pas d'objets");
        }
        for (Utilitaire objet : objets) {
            count += 1;
            res += count + ". " + objet.nom + "\n";
        }

        return res;
    }

    /**
     * Permet au joueur d'utiliser un objet de son inventaire.
     * Affiche les objets disponibles et applique leur effet si un choix valide est fait.
     */
    public void useObjets() {
        if (this.objets.isEmpty()) {
            System.out.println("Vous n'avez aucun objet à utiliser !");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Voici les objets disponibles :");
        for (int i = 0; i < this.objets.size(); i++) {
            System.out.println((i + 1) + ". " + this.objets.get(i).getNom());
        }

        System.out.print("\nQuel objet voulez-vous utiliser ? Entrez un numéro : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix < 1 || choix > this.objets.size()) {
            System.out.println("Choix invalide. Veuillez réessayer.");
            return;
        }

        choix = choix - 1;
        this.objets.get(choix).useEffect(this);
        this.objets.remove(choix);
        System.out.println("L'objet a été utilisé !");
    }

    /**
     * Retourne le score actuel du joueur.
     *
     * @return Le score du joueur.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Définit le score du joueur.
     *
     * @param score La nouvelle valeur du score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Augmente le score du joueur d'une valeur donnée.
     *
     * @param value La valeur à ajouter au score.
     */
    public void augmenteScore(int value) {
        int score = getScore();
        score = score + value;
        setScore(score);
    }
}
