package utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLConfig {

    /**
     * |Method that dynamically retrieves URL string from data.xml
     */

    public static String getURL() throws Exception{
        File fXmlFile = new File("/Users/epikover/IdeaProjects/Java/QA_Experts/Project_WebTesting_Selenium/src/main/resources/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName("URL").item(0).getTextContent();

    }
    /**
     * |Method that dynamically retrieves Browser Type string from data.xml
     */

    public static String getBrowser() throws Exception{
        File fXmlFile = new File("/Users/epikover/IdeaProjects/Java/QA_Experts/Project_WebTesting_Selenium/src/main/resources/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName("browserTypeMain").item(0).getTextContent();

    }

}


