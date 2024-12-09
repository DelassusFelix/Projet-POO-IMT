package Projet_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends Personnage {

    Utilitaire capacite;
    List<Utilitaire> objets = new ArrayList<>();
    int score; 

    public Joueur(int pv, int force, int defense, int esquive, int critique, String nom){
        super(nom, pv, force, defense, esquive, critique);
        
    }

    @Override
    public String toString(){
        String data = super.toString();
        return data + "\nnom : " + nom;

    }

    public Utilitaire getCapacite(){
        return this.capacite; 
    }

    public void setCapacite(Utilitaire capacite)
    {
        if (capacite instanceof CapaciteActiveInterface){
            this.capacite = capacite; 
        }
        if (capacite instanceof CapacitePassiveInterface){
            this.capacite = capacite; 
        }
    }

    public void utiliserCapacite(Joueur joueur) {
        this.capacite.useEffect(joueur);
    }
        
    public List<Utilitaire> getObjets(){
        return this.objets; 
    }

    public void addObjet(Utilitaire objet){
        if (objet instanceof ObjetInterface){
            this.objets.add(objet);  
        }
    }

    public String showObjets(){
        int count = 0; 
        String res = "";
        System.out.println("\nObjets :");
        if (this.objets.isEmpty()){
            System.out.println("Vous n'avez pas d'objets");
        }
        for (Utilitaire objet : objets) {
            count += 1; 
            res += count + ". " + objet.nom + "\n"; 
        }

        return res; 
    }

    public void useObjets() {
        // Vérification si le joueur a des objets
        if (this.objets.isEmpty()) {
            System.out.println("Vous n'avez aucun objet à utiliser !");
            return; // Sortie de la méthode
        }

        Scanner scanner = new Scanner(System.in);

        // Affichage des objets disponibles
        System.out.println("Voici les objets disponibles :");
        for (int i = 0; i < this.objets.size(); i++) {
            System.out.println((i + 1) + ". " + this.objets.get(i).getNom());
        }

        System.out.print("\nQuel objet voulez-vous utiliser ? Entrez un numéro : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme la ligne restante

        // Validation du choix
        if (choix < 1 || choix > this.objets.size()) {
            System.out.println("Choix invalide. Veuillez réessayer.");
            return;
        }

        // Utilisation de l'objet
        choix = choix - 1; // Convertir en index basé sur 0
        this.objets.get(choix).useEffect(this); // Appliquer l'effet de l'objet
        this.objets.remove(choix); // Retirer l'objet de l'inventaire
        System.out.println("L'objet a été utilisé !");
    }


    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score; 
    }

    public void augmenteScore(int value){
        int score = getScore();
        score= score + value;
        setScore(score); 
    }
}