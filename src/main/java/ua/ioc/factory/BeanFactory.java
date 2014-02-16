package ua.ioc.factory;


/**
 * Created by mykhailo on 2/15/14.
 */
public interface BeanFactory {
    Object getBean(String beanId);
    <T extends Object> T getBean(String beanId,Class<T> type);
}
