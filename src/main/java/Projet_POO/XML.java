package Projet_POO;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {

    public XML() {}

    /**
     * Méthode pour charger et parser le fichier XML.
     * Cette méthode est utilisée dans toutes les méthodes qui nécessitent une lecture du fichier XML.
     *
     * @return Le document XML chargé
     * @throws Exception Si une erreur se produit lors du chargement du fichier
     */
    private Document chargerXML() throws Exception {
        File file = new File("score.xml");
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();
        return document;
    }

    /**
     * Modifie le score d'un joueur dans le fichier XML.
     * Si le nouveau score est plus élevé que l'actuel, le score et le nom du joueur sont mis à jour.
     *
     * @param carteArg La carte pour laquelle on souhaite modifier le score
     * @param nouveauScoreInt Le nouveau score du joueur
     * @param nomJoueur Le nom du joueur
     */
    public void modifyXML(Carte carteArg, int nouveauScoreInt, String nomJoueur) {
        try {
            // Charger le fichier XML
            Document document = chargerXML();

            // Récupérer la liste des cartes
            NodeList cartes = document.getElementsByTagName("carte");

            // Parcourir les cartes pour trouver celle qui nous intéresse
            for (int i = 0; i < cartes.getLength(); i++) {
                Node carte = cartes.item(i);
                if (carte.getNodeType() == Node.ELEMENT_NODE) {
                    Element carteElement = (Element) carte;

                    // Vérifier si c'est la carte recherchée
                    String nomCarte = carteElement.getElementsByTagName("nomCarte").item(0).getTextContent();
                    if (nomCarte.equals(carteArg.getNom())) {
                        // Modifier le score si le nouveau score est plus élevé
                        Element scoreActuel = (Element) carteElement.getElementsByTagName("score").item(0);
                        int scoreActuelInt = Integer.parseInt(scoreActuel.getTextContent());
                        Element nomActuel = (Element) carteElement.getElementsByTagName("nomJoueur").item(0);

                        if (nouveauScoreInt > scoreActuelInt) {
                            scoreActuel.setTextContent(String.valueOf(nouveauScoreInt));
                            nomActuel.setTextContent(nomJoueur);
                            System.out.println("Score modifié avec succès.");
                            break; // Quitter la boucle après la modification
                        }
                    }
                }
            }

            // Sauvegarder les modifications dans le fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("score.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("Fichier XML mis à jour avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Affiche les scores d'un joueur pour une carte donnée.
     *
     * @param carteArg La carte pour laquelle on veut afficher le score
     * @return Le score du joueur sous forme de chaîne de caractères
     */
    public String afficherScore(Carte carteArg) {
        System.out.print("\n=== Tableau des scores ===\n");
        System.out.print("== " + carteArg.getNom() + " ==\n");

        try {
            // Charger le fichier XML
            Document document = chargerXML();

            // Récupérer la liste des cartes
            NodeList cartes = document.getElementsByTagName("carte");

            String affichage = "";

            // Parcourir les cartes pour trouver celle qui nous intéresse
            for (int i = 0; i < cartes.getLength(); i++) {
                Node carte = cartes.item(i);

                if (carte.getNodeType() == Node.ELEMENT_NODE) {
                    Element carteElement = (Element) carte;

                    // Vérifier si c'est la carte recherchée
                    String nomCarte = carteElement.getElementsByTagName("nomCarte").item(0).getTextContent();
                    if (nomCarte.equals(carteArg.getNom())) {
                        String nomJoueur = carteElement.getElementsByTagName("nomJoueur").item(0).getTextContent();
                        String scoreJoueur = carteElement.getElementsByTagName("score").item(0).getTextContent();
                        affichage = affichage + "Joueur : " + nomJoueur + "\n" + "score : " + scoreJoueur + "\n\n";
                    }
                }
            }

            return affichage;
        } catch (Exception e) {
            return "Erreur lors de l'affichage du score";
        }
    }
}
