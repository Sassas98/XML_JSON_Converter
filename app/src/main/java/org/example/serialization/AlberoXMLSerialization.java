package org.example.serialization;

import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.example.model.Albero;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AlberoXMLSerialization {
    public String serialize(List<Albero> alberi){
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = doc.createElement("alberi");
            doc.appendChild(root);
            for(Albero albero : alberi){
                Element alberoElement = getAlberoElement(doc, albero);
                root.appendChild(alberoElement);
            }
            return serializeDocumentToString(doc);
        } catch (Exception e) {
            throw new SerializationException("Errore nella serializzazione del file XML: " + e.getMessage());
        }
    }

    private String serializeDocumentToString(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.toString();
    }

    private Element getAlberoElement(Document doc, Albero albero){
        Element alberoElement = doc.createElement("albero");
        alberoElement.setAttribute("id", String.valueOf(albero.getId()));
        alberoElement.setAttribute("nome", albero.getNome());
        alberoElement.setAttribute("altezza", String.valueOf(albero.getAltezza()));
        Element descrizione = doc.createElement("descrizione");
        descrizione.setTextContent(albero.getDescrizione());
        alberoElement.appendChild(descrizione);
        return alberoElement;
    }
}
