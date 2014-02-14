package ua.ioc.beans;

import ua.ioc.beans.parameters.constructor.ConstructorArg;
import ua.ioc.beans.parameters.property.Property;
import ua.ioc.util.BeanNameUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class BeanDefinition {
    Map<String,String> attributes;
    Map<String,List<Map<String,String>>> parameters;

    public BeanDefinition(Map<String, String> attributes, Map<String, List<Map<String, String>>> parameters) {
        this.attributes = attributes;
        this.parameters = parameters;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, List<Map<String, String>>> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, List<Map<String, String>>> parameters) {
        this.parameters = parameters;
    }
}
