package ua.ioc.beans.parameters.property;

import ua.ioc.beans.parameters.Parameter;
import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public abstract class Property implements Parameter {
    protected ParameterType type;
    protected String name;

    protected Property(ParameterType type, String name) {
        this.type = type;
        this.name = name;
    }

    public ParameterType getType() {
        return type;
    }

    public void setType(ParameterType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
