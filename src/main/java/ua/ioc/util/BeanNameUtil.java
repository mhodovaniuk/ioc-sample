package ua.ioc.util;

import sun.launcher.resources.launcher;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class BeanNameUtil {
    private BeanNameUtil() {
    }

    public static String toBeanName(String clazzName){
        int lastDotIndex=clazzName.lastIndexOf('.');
        if (lastDotIndex==-1)
            lastDotIndex=0;
        clazzName=clazzName.substring(lastDotIndex);
        return Character.toLowerCase(clazzName.charAt(0))+clazzName.substring(1);
    }

    public static String getSetterName(String beanName){
        return "set"+Character.toUpperCase(beanName.charAt(0))+beanName.substring(1);
    }
}
