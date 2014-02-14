package ua.ioc.beans.parameters.constructor;

import ua.ioc.beans.parameters.Parameter;
import ua.ioc.beans.parameters.ParameterType;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public abstract class ConstructorArg implements Parameter {
    protected ParameterType type;

    protected ConstructorArg(ParameterType type) {
        this.type = type;
    }

    public ParameterType getType() {
        return type;
    }

    public void setType(ParameterType type) {
        this.type = type;
    }


}
