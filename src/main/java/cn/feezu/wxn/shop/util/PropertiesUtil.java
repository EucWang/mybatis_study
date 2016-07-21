package cn.feezu.wxn.shop.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by wangxn on 2016/7/21.
 */
public class PropertiesUtil {

    private static Properties daoProperties;

    public static Properties getDaoProperties() {
        try {
            if (daoProperties == null) {
                daoProperties = new Properties();
                InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("dao.properties");
                daoProperties.load(resourceAsStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  daoProperties;
    }

    public static Object getObj(Properties properties, String daoClazzName) {
        String addressDaoClassName = properties.getProperty(daoClazzName);
        try {
            Class<?> dao = Class.forName(addressDaoClassName);
            return dao.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getInstance(Properties properties, String factoryName) {
        String factory = properties.getProperty(factoryName);
        Object retVal = null;
        try {
            Class aClass = Class.forName(factory);
            Method getInstanceMethod = aClass.getMethod("getInstance");
            retVal = getInstanceMethod.invoke(factory);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
