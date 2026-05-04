package org.example.serialization;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.example.model.Persona;
import org.example.utility.ResourceReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class PersonaXMLDeserializator extends ResourceReader {
    public List<Persona> deserialize() {
        try{
            Document document = getDocument("persone.xml");
            NodeList persone = document.getElementsByTagName("Persona");
            List<Persona> list = new LinkedList<>();
            for (int i = 0; i < persone.getLength(); i++) {
                Element element = (Element) persone.item(i);
                Persona persona = getPersona(element);
                list.add(persona);
            }
            return list;
        } catch(Exception ex){
            throw new SerializationException("Errore nella lettura del file persone.xml: " + ex.getMessage());
        }
    }

    private Persona getPersona(Element element){
        var persona = new Persona();
        String nome = readNodeText(element, "Nome");
        persona.setNome(nome);
        String cognome = readNodeText(element, "Cognome");
        persona.setCognome(cognome);
        int eta = Integer.parseInt(readNodeText(element, "Eta"));
        persona.setEta(eta);
        String residenza = readNodeText(element, "Residenza");
        persona.setResidenza(residenza);
        return persona;
    }

    private Document getDocument(String resourceName) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(
            new InputSource(new StringReader(readFile(resourceName)))
        );
        document.getDocumentElement().normalize();
        return document;
    }

    private String readNodeText(Element elemento, String tag) {
        return elemento.getElementsByTagName(tag)
                .item(0)
                .getTextContent();
    }
}
