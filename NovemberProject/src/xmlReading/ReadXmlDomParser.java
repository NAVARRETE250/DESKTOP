package xmlReading;

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

          // optional, but recommended
          // process XML securely, avoid attacks like XML External Entities (XXE)
          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          // parse XML file
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));

          // optional, but recommended
          // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();

          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
          System.out.println("------");

          // get <staff>
          NodeList list = doc.getElementsByTagName("configuracion");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  // get staff's attribute
//                  String id = element.getAttribute("id");

                  // get text
//                  String name = element.getElementsByTagName("name").item(0).getTextContent();
//                  String platform = element.getElementsByTagName("platform").item(0).getTextContent();
//                  String publisher = element.getElementsByTagName("publisher").item(0).getTextContent();
//
//                  NodeList priceNodeList = element.getElementsByTagName("price");
//                  String price = priceNodeList.item(0).getTextContent();

                  // get salary's attribute
//                  String currency = priceNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();
//
//                  System.out.println("Current Element :" + node.getNodeName());
//                  System.out.println("Game Id : " + id);
//                  System.out.println("Name : " + name);
//                  System.out.println("Platform : " + platform);
//                  System.out.println("Publisher : " + publisher);
//                  System.out.printf("Price [Currency] : %,.2f [%s]%n%n", Float.parseFloat(price), currency);
                  
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