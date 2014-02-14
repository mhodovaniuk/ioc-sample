package ua.ioc.beans.parameters.property;

import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class PropertyVal extends Property {
    protected String val;

    public PropertyVal(ParameterType type, String name, String val) {
        super(ParameterType.VALUE, name);
        this.val = val;
    }

    @Override
    public String getValue() {
        return null;
    }
}
