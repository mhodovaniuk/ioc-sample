package ua.ioc.beans.parameters.constructor;

import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class ConstructorRefArg extends ConstructorArg {
    protected String ref;

    public ConstructorRefArg(String ref) {
        super(ParameterType.REFERENCE);
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String getValue() {
        return ref;
    }
}
