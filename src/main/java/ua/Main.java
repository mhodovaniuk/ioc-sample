package ua;

import org.xml.sax.SAXException;
import ua.ioc.GenericXmlApplicationContext;
import ua.ioc.beans.BeanDefinition;
import ua.ioc.factory.BeanFactory;
import ua.ioc.parsers.DOMParser;
import ua.ioc.parsers.XMLParser;
import ua.test.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        GenericXmlApplicationContext context=new GenericXmlApplicationContext();
        context.load("ioc.xml");
        BeanFactory beanFactory = context.getBeanFactory();
        Test test = beanFactory.getBean("test", Test.class);
        test.say();
        System.out.println(Long.valueOf("2333342"));

    }
}
