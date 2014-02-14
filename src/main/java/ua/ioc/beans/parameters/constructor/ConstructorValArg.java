package ua.ioc.beans.parameters.constructor;

import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class ConstructorValArg extends ConstructorArg {
    protected String val;
    public ConstructorValArg(String val) {
        super(ParameterType.VALUE);
        this.val=val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String getValue() {

        return val;
    }
}
