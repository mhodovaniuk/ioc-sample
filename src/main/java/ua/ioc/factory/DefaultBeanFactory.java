package ua.ioc.factory;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ua.ioc.beans.BeanDefinition;
import ua.ioc.util.BeanNameUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.ioc.beans.BeanDefinition.*;

/**
 * Created by mykhailo on 2/15/14.
 */
public class DefaultBeanFactory implements BeanFactory {
    private List<BeanDefinition> beanDefinitionList;
    private Map<String, Object> beans = new HashMap<>();

    public DefaultBeanFactory(List<BeanDefinition> beanDefinitionList) throws Exception {
        this.beanDefinitionList = beanDefinitionList;
        createBeans();
    }

    private void createBeans() throws Exception {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            if (!isBeanExists(beanDefinition.getId()))
                createBean(beanDefinition);
        }
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        Class<?> beanClass = Class.forName(beanDefinition.getAttributes().get(CLASS));
        Object bean = constructBean(beanClass, beanDefinition);
        setBeanProperties(bean, beanClass, beanDefinition);
        beans.put(beanDefinition.getId(), bean);
        return bean;

    }

    private Object createBean(String beanId) throws Exception {
        return createBean(findBeanDefinition(beanId));
    }

    private void setBeanProperties(Object bean, Class<?> beanClass, BeanDefinition beanDefinition) throws Exception {
        for (Map<String, String> property : beanDefinition.getParameters().get(PROPERTY)) {
            String propertyName=property.get(NAME);
            Class<?> propertyType=BeanUtil.getFieldType(beanClass,propertyName);
            Object propertyValue=getParameterValue(property,propertyType);
            BeanUtil.setBeanProperty(bean,property.get(NAME), propertyValue);
        }
    }

    private Object getParameterValue(Map<String, String> parameter, Class<?> parameterType) throws Exception {
        if (parameter.containsKey(VALUE))
            return BeanUtil.getParameterValue(parameterType, parameter.get(VALUE));
        else
            return findOrCreateBean(parameter.get(REF));
    }


    private Object constructBean(Class<?> beanClass, BeanDefinition beanDefinition) throws Exception {
        List<Map<String, String>> constructorArg = beanDefinition.getParameters().get(CONSTRUCTOR_ARG);
        Constructor<?>[] constructors = beanClass.getConstructors();
        for (Constructor constructor : constructors)
            if (constructor.getParameterTypes().length == constructorArg.size()) {
                Object bean = tryConstruct(constructor, constructorArg);
                if (bean != null)
                    return bean;
            }
        throw new BeanNotFoundException(beanDefinition.getId());
    }

    private Object tryConstruct(Constructor constructor, List<Map<String, String>> constructorArgs) throws Exception {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object parameters[] = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Map<String, String> constructorArg = constructorArgs.get(i);
            parameters[i]=getParameterValue(constructorArg,parameterTypes[i]);
        }
        return constructor.newInstance(parameters);
    }


    private Object findOrCreateBean(String beanId) throws Exception {
        if (isBeanExists(beanId))
            return findBean(beanId);
        else
            return createBean(beanId);
    }

    private BeanDefinition findBeanDefinition(String beanId) {
        for (BeanDefinition beanDefinition : beanDefinitionList)
            if (beanDefinition.getAttributes().get(ID).equals(beanId))
                return beanDefinition;
        throw new BeanNotFoundException(beanId);
    }

    private boolean isBeanExists(String beanId) {
        return findBean(beanId) != null;
    }

    private Object findBean(String beanId) {
        return beans.get(beanId);
    }


    @Override
    public Object getBean(String beanId) {
        Object bean = findBean(beanId);
        if (bean == null)
            throw new BeanNotFoundException(beanId);
        else return bean;
    }

    @Override
    public <T> T getBean(String beanId, Class<T> type) {
        return type.cast(getBean(beanId));
    }
}