package cn.feezu.wxn.shop.util;

import cn.feezu.wxn.shop.dao.IDaoFactory;
import cn.feezu.wxn.shop.model.ShopDi;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by wangxn on 2016/7/21.
 */
public class DaoUtil {

    public static IDaoFactory getDaoFactory() {
        Properties daoProperties = PropertiesUtil.getDaoProperties();
        Object factory = PropertiesUtil.getInstance(daoProperties, "factory");
        return (IDaoFactory) factory;
    }

    //自定义依赖注入
//    public static void injectDao(Object obj) {
//        try {
//            //获取当前类定义的方法数组
//            Method[] methods = obj.getClass().getDeclaredMethods();
//            for (Method method : methods) {
//                String methodName = method.getName();
//                if (methodName.startsWith("set")) {  //方法名以set开头
//                    //获取对象属性名称
//                    String methodHandleAttri = methodName.substring(3);
//                    //首字母小写
//                    methodHandleAttri = methodHandleAttri.substring(0, 1).toLowerCase() + methodHandleAttri.substring(1);
//
//                    //调用工厂获取DAO对象
//                    Object dao = DaoUtil.getDaoFactory().getDao(methodHandleAttri);
//
//                    //将获取的DAO对象进行注入
//                    method.invoke(obj, dao);
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 使用注解来使用依赖注入
     *
     * @param obj
     */
    public static void injectDao(Object obj) {
        try {
            //获取当前类定义的方法数组
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                //获取注解
                ShopDi annotation = method.getAnnotation(ShopDi.class);
                if (annotation == null) {
                    continue;
                }
                //获取注解的默认值
                String value = annotation.value();
                //如果为空,则使用方法名称来注入
                if (null == value || "".equals(value.trim())) {
                    value = method.getName();
                    if (value.startsWith("set")) {  //方法名以set开头
                        //获取对象属性名称
                        value = value.substring(3);
                        //首字母小写
                        value = value.substring(0, 1).toLowerCase() + value.substring(1);
                    }
                }
                //调用工厂获取DAO对象
                Object dao = DaoUtil.getDaoFactory().getDao(value);

                //将获取的DAO对象进行注入
                method.invoke(obj, dao);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
