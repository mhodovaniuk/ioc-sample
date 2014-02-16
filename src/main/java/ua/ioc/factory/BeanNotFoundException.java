package ua.ioc.factory;

/**
 * Created by mykhailo on 2/16/14.
 */
public class BeanNotFoundException extends Error {
    public BeanNotFoundException(String message) {
        super(message);
    }
}
