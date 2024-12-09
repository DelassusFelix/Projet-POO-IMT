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

/**
 * Classe ModifyXMLFileScore utilisée pour modifier le score dans un fichier XML.
 * Cette classe cherche une partie spécifique par son nom, puis met à jour son score.
 */
public class ModifyXMLFileScore {

    /**
     * Constructeur de la classe ModifyXMLFileScore.
     * Modifie le score d'une partie spécifique dans un fichier XML.
     *
     * @param nomFichier      Nom du fichier XML à modifier.
     * @param quelTag         Nom du tag XML contenant les parties.
     * @param quellePartie    Nom de la partie dont le score doit être modifié.
     * @param quelNouveauScore Nouveau score à attribuer à la partie.
     */
    public ModifyXMLFileScore(
            String nomFichier,
            String quelTag,
            String quellePartie,
            String quelNouveauScore
    ) {
        try {
            // Charger le fichier XML
            File file = new File(nomFichier);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            // Normaliser le document (facultatif)
            document.getDocumentElement().normalize();

            // Récupérer la liste des parties
            NodeList parties = document.getElementsByTagName(quelTag);

            // Parcourir les parties pour trouver celle qui nous intéresse
            for (int i = 0; i < parties.getLength(); i++) {
                Node partie = parties.item(i);

                if (partie.getNodeType() == Node.ELEMENT_NODE) {
                    Element partieElement = (Element) partie;

                    // Vérifier si c'est celle qui nous intéresse
                    String nomPartie = partieElement.getElementsByTagName("nomPartie").item(0).getTextContent();

                    if (nomPartie.equals(quellePartie)) {
                        // Modifier le score
                        Element score = (Element) partieElement.getElementsByTagName("score").item(0);
                        score.setTextContent(quelNouveauScore);
                        System.out.println("Score modifié avec succès.");
                        break; // Quitter la boucle une fois la modification faite
                    }
                }
            }

            // Sauvegarder les modifications dans le fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("employees.xml"));

            transformer.transform(domSource, streamResult);

            System.out.println("Fichier XML mis à jour avec succès !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
