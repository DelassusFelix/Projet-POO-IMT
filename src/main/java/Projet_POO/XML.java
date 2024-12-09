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

    public XML() {

    }; 

    // TODO factoriser le code commun au début de modifierXML() et afficherScore() par une fonction chargerXML() 

    public void modifyXML(Carte carteArg, int nouveauScoreInt, String nomJoueur) 
    {
        try {
            // Charger le fichier XML
            File file = new File("score.xml");
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            // Normaliser le document
            document.getDocumentElement().normalize();

            // Récupérer la liste des parties
            NodeList cartes = document.getElementsByTagName("carte");

            // Parcourir les parties pour trouver celle qui nous interesse
            for (int i = 0; i < cartes.getLength(); i++) {
                Node carte = cartes.item(i);
                System.out.println(cartes.item(i));

                if (carte.getNodeType() == Node.ELEMENT_NODE) {
                    Element carteElement = (Element) carte;

                    // Vérifier si c'est celle qui nous interesse
                    String nomCarte = carteElement.getElementsByTagName("nomCarte").item(0).getTextContent();

                    if (nomCarte.equals(carteArg.getNom())) {
                        // Modifier le score
                        Element scoreActuel = (Element) carteElement.getElementsByTagName("score").item(0);
                        int scoreActuelInt = Integer.parseInt(scoreActuel.getTextContent());
                        Element nomActuel = (Element) carteElement.getElementsByTagName("nomJoueur").item(0);

                        if (nouveauScoreInt > scoreActuelInt) {
                            String nouveauScoreStr = "" + nouveauScoreInt;
                            scoreActuel.setTextContent(nouveauScoreStr);
                            nomActuel.setTextContent(nomJoueur);
                            System.out.println("Score modifié avec succès.");
                            break; // Quitter la boucle une fois la modification faite

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

    public String afficherScore(Carte carteArg){

        System.out.print("\n=== Tableau des scores ===\n");
        System.out.print("== " + carteArg.getNom() + " ==\n");

        try {
          // Charger le fichier XML
          File file = new File("score.xml");
          DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
          Document document = documentBuilder.parse(file);

          // Normaliser le document
          document.getDocumentElement().normalize();

          // Récupérer la liste des parties
          NodeList cartes = document.getElementsByTagName("carte");

          String affichage = "";

          // Parcourir les parties pour trouver celle qui nous interesse
          for (int i = 0; i < cartes.getLength(); i++) {
              Node carte = cartes.item(i);

              if (carte.getNodeType() == Node.ELEMENT_NODE) {
                  Element carteElement = (Element) carte;

                  // Vérifier si c'est celle qui nous interesse
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
            return "erreur affichage"; 
        }
    }

}
    

