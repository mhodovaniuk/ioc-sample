package ua.ioc.factory;

import ua.ioc.util.BeanNameUtil;

import java.beans.Statement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mykhailo on 2/16/14.
 */
public class BeanUtil {
    private BeanUtil() {

    }

    public static Class getBoxingClassForPrimitives(Class aClass) {
        if (aClass == int.class)
            return Integer.class;

        if (aClass == byte.class)
            return Byte.class;

        if (aClass == boolean.class)
            return Boolean.class;

        if (aClass == char.class)
            return Character.class;

        if (aClass == long.class)
            return Long.class;

        if (aClass == float.class)
            return Float.class;

        if (aClass == double.class)
            return Double.class;
        return aClass;
    }

    public static Object getParameterValue(Class<?> parameterClass, String stringValue) {
        try {
            if (parameterClass == String.class)
                return stringValue;
            Class<?> clazz = BeanUtil.getBoxingClassForPrimitives(parameterClass);
            if (clazz == Character.class)
                return stringValue.charAt(0);
            Method valueOfMethod = clazz.getMethod("valueOf", String.class);
            return valueOfMethod.invoke(null, stringValue);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
            ignored.printStackTrace();
            return null;
        }
    }


    public static Class<?> getFieldType(Class<?> beanClass, String propertyName) throws NoSuchFieldException {
        return beanClass.getDeclaredField(propertyName).getType();
    }


    public static void setBeanProperty(Object bean, String propertyName, Object propertyValue) throws Exception {
        Statement statement=new Statement(bean, BeanNameUtil.getSetterName(propertyName),new Object[]{propertyValue});
        statement.execute();
    }
}
