package ua.ioc.parsers;

import org.xml.sax.SAXException;
import ua.ioc.beans.BeanDefinition;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface XMLParser {
    List<BeanDefinition> parse() throws IOException, SAXException, ParserConfigurationException;
}
