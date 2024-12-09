package Projet_POO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe {@code Logger} permet d'enregistrer des messages dans un fichier
 * texte et de les afficher dans la console.
 * Elle gère l'écriture de logs dans un fichier spécifique et garantit que
 * chaque message est écrit à la suite des précédents.
 */
public class Logger {
    private FileWriter writer;

    /**
     * Constructeur de la classe {@code Logger}.
     * Initialise un {@code FileWriter} qui ouvre le fichier spécifié en mode ajout
     * (les nouveaux logs seront ajoutés à la fin du fichier existant).
     *
     * @param fileName Le nom du fichier dans lequel les logs seront enregistrés.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'ouverture
     *                     du fichier.
     */
    public Logger(String fileName) throws IOException {
        this.writer = new FileWriter(fileName, true);
    }

    /**
     * Enregistre un message dans le fichier de log et l'affiche dans la console.
     * Le message est écrit à la suite des précédents, et chaque message est
     * suivi d'un retour à la ligne.
     *
     * @param message Le message à enregistrer dans le fichier et à afficher dans
     *                la console.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture
     *                     dans le fichier.
     */
    public void log(String message) throws IOException {
        System.out.println(message); // Affiche le message dans la console.
        writer.write(message + "\n"); // Écrit le message dans le fichier.
        writer.flush(); // Force l'écriture immédiate dans le fichier.
    }

    /**
     * Ferme le {@code FileWriter}, libérant ainsi les ressources associées.
     * Cette méthode doit être appelée lorsque le processus de journalisation est terminé.
     *
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de la fermeture
     *                     du fichier.
     */
    public void close() throws IOException {
        writer.close();
    }
}
