package ua.ioc.parsers;

import com.sun.corba.se.spi.activation._LocatorImplBase;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ua.ioc.beans.BeanDefinition;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mykhailo_Hodovaniuk on 2/14/14.
 */
public class DOMParser implements XMLParser {
    private static ParserType type=ParserType.DOM;

    @Override
    public List<BeanDefinition> parse(String xmlFileName) throws IOException, SAXException, ParserConfigurationException {
        List<BeanDefinition> result=new ArrayList<>();
        File fXmlFile = new File(xmlFileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("bean");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element=(Element)nodeList.item(i);
            result.add(new BeanDefinition(processAttributes(element),processParameters(element)));
        }
        return result;
    }

    private Map<String, List<Map<String, String>>> processParameters(Element element) {
        Map<String, List<Map<String, String>>> parameters=new HashMap<>();
        NodeList nodes = element.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item=nodes.item(i);
            addToMap(parameters, item.getNodeName() ,processAttributes(item));
        }
        return parameters;
    }

    @Override
    public ParserType getType() {
        return type;
    }

    private Map<String, String> processAttributes(Node node) {
        Map<String,String> result=new HashMap<>();
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0;  i < attributes.getLength() ; i++) {
            Node item = attributes.item(i);
            result.put(item.getNodeName(), item.getNodeValue());
        }
        return result;
    }

    private void addToMap(Map<String, List<Map<String, String>>> map,String elementName, final Map<String,String> attributes){
        if (map.containsKey(elementName))
            map.get(elementName).add(attributes);
        else map.put(elementName,new ArrayList<Map<String, String>>(){{add(attributes);}});
    }
}