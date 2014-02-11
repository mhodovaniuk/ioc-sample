package ua.ioc.beans;

/**
 * Created by Mykhailo_Hodovaniuk on 2/11/14.
 */
public class ConstructorArg {
    private String value;
    private String ref;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }
}
