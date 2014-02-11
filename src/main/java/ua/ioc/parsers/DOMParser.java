package ua.ioc.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.ioc.beans.Bean;
import ua.ioc.beans.ConstructorArg;
import ua.ioc.beans.Property;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class DOMParser implements XMLParser {
    @Override
    public List<Bean> parse(File file) throws IOException, SAXException, ParserConfigurationException {
        List<Bean> beans=new ArrayList<Bean>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList=doc.getElementsByTagName("bean");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Bean bean=new Bean();
            Node beanNode=nodeList.item(i);
            NamedNodeMap attributes = beanNode.getAttributes();
            bean.setId(attributes.getNamedItem("id").getTextContent());
            bean.setClazz(attributes.getNamedItem("class").getTextContent());
            NodeList paramNodeList = beanNode.getChildNodes();
            List<ConstructorArg> constructorArgs=new ArrayList<>();
            List<Property> properties=new ArrayList<>();
            for (int j = 0; j < paramNodeList.getLength(); j++) {
                Node paramNode=paramNodeList.item(j);
                switch (paramNode.getLocalName()){
                    case "constructor-arg":
                        ConstructorArg constructorArg=new ConstructorArg();
                        constructorArg.setValue(paramNode.getAttributes().getNamedItem("value").getTextContent());
                        constructorArg.setRef(paramNode.getAttributes().getNamedItem("ref").getTextContent());
                        constructorArgs.add(constructorArg);
                        break;
                    case "property":
                        Property property=new Property();
                        property.setValue(paramNode.getAttributes().getNamedItem("name").getTextContent());
                        property.setValue(paramNode.getAttributes().getNamedItem("ref").getTextContent());
                        property.setValue(paramNode.getAttributes().getNamedItem("value").getTextContent());
                        properties.add(property);
                        break;
                }
            }
            bean.setConstructorArgs(constructorArgs);
            bean.setProprties(properties);
            beans.add(bean);
        }
        return beans;
    }
}
