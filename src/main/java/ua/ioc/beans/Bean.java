package ua.ioc.beans;

import org.w3c.dom.Node;

import java.util.List;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class Bean {

    private String id;
    private String clazz;
    private List<ConstructorArg> constructorArgs;
    private List<Property> proprties;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getClazz() {
        return clazz;
    }


    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setProprties(List<Property> proprties) {
        this.proprties = proprties;
    }

    public List<Property> getProprties() {
        return proprties;
    }
}
