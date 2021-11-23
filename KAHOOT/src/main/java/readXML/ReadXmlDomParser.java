package main.java.readXML;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlDomParser {

  private static final String FILENAME = "./config.xml";

  private String language;
  private String timeout;
  private String maxQuestions;
  


public ReadXmlDomParser(){};
  
  
  public void readXML() {
	  
	  // Instantiate the Factory
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {

          // process XML securely, avoid attacks like XML External Entities (XXE)
          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          // parse XML file
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));

          doc.getDocumentElement().normalize();

          NodeList list = doc.getElementsByTagName("configuracion");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  language = element.getElementsByTagName("idioma").item(0).getTextContent();
                  timeout = element.getElementsByTagName("timeout").item(0).getTextContent();
                  maxQuestions = element.getElementsByTagName("max_preguntas").item(0).getTextContent();
                 
                  
                  
              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
  }
 
  //Getters and Setters
  public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getTimeout() {
		return timeout;
	}


	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}


	public String getMaxQuestions() {
		return maxQuestions;
	}


	public void setMaxQuestions(String maxQuestions) {
		this.maxQuestions = maxQuestions;
	}
  
}