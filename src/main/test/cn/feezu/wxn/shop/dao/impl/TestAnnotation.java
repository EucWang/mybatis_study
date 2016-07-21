package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.model.ShopDi;
import org.junit.Test;

import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by wangxn on 2016/7/21.
 */
public class TestAnnotation {

//    @ShopDi(value="sss")
    public void aa(){}

    @Test
    public void test(){

        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        for (Method method: declaredMethods){
            if (method.isAnnotationPresent(ShopDi.class)){
                ShopDi annotation = method.getAnnotation(ShopDi.class);
                String value = annotation.value();
                if (null == value || "".equals(value.trim())) {
                    value = method.getName();
                }
                System.out.println(value);
            }
        }
    }
}
