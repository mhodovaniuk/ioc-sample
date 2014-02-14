package ua.ioc.util;

import sun.launcher.resources.launcher;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class BeanNameUtil {
    private BeanNameUtil() {
    }

    public static String toBeanName(String clazz){
        int lastDotIndex=clazz.lastIndexOf('.');
        if (lastDotIndex==-1)
            lastDotIndex=0;
        clazz=clazz.substring(lastDotIndex);
        return Character.toLowerCase(clazz.charAt(0))+clazz.substring(1);
    }
}
