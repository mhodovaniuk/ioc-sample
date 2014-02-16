package ua.ioc.beans;

import java.util.List;
import java.util.Map;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class BeanDefinition {
    public static final String ID="id", CLASS="class",CONSTRUCTOR_ARG="constructor-arg",PROPERTY="property"
            ,VALUE="value", REF="ref", NAME="name";
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

    public String getId(){
        return getAttributes().get(ID);
    }
}
