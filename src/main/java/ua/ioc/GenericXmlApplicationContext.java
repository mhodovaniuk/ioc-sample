package ua.ioc;

import org.xml.sax.SAXException;
import ua.ioc.beans.BeanDefinition;
import ua.ioc.factory.BeanFactory;
import ua.ioc.factory.DefaultBeanFactory;
import ua.ioc.parsers.DOMParser;
import ua.ioc.parsers.ParserType;
import ua.ioc.parsers.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class GenericXmlApplicationContext {
    private boolean validating;
    private String xmlFileName;
    private XMLParser parser;

    public GenericXmlApplicationContext() {
        validating=false;
        setParserType(ParserType.DOM);
    }

    public void load(String xmlFileName){
        this.xmlFileName=xmlFileName;
    }

    public void setParserType(ParserType type){
        switch (type){
            case DOM:
                parser=new DOMParser();
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public boolean isValidating() {
        return validating;
    }

    public void setValidating(boolean validating) {
        this.validating = validating;
    }

    public BeanFactory getBeanFactory(){
        try {
            List<BeanDefinition> beanDefinitionList = parser.parse(xmlFileName);
            return new DefaultBeanFactory(beanDefinitionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
