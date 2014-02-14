package ua.ioc.beans.parameters.property;

import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class PropertyRef extends Property {
    protected String ref;
    public PropertyRef(String name,String ref) {
        super(ParameterType.REFERENCE, name);
        this.ref=ref;
    }

    public String getRef() {
        return ref;
    }

    @Override
    public String getValue() {
        return ref;
    }
}
