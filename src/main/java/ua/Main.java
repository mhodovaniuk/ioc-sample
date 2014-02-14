package ua;

import org.xml.sax.SAXException;
import ua.ioc.beans.BeanDefinition;
import ua.ioc.parsers.DOMParser;
import ua.ioc.parsers.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        XMLParser xmlParser=new DOMParser("ioc.xml");
        List<BeanDefinition> parse = xmlParser.parse();
        System.out.println(parse);
    }
}
