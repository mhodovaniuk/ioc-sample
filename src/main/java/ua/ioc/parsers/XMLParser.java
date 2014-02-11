package ua.ioc.parsers;

import org.xml.sax.SAXException;
import ua.ioc.beans.Bean;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public interface XMLParser {
    List<Bean> parse(File file) throws IOException, SAXException, ParserConfigurationException;
}
