package cn.feezu.wxn.shop.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用这个Annotation来标注需要进行依赖注入的方法
 * @ShopDi("userDao") 就说明该方法是注入userDao对象
 * 如果@ShopDi就规定该方法使用setXX来注入,
 * 如果方法是setUserDao表示注入userDao
 * Created by wangxn on 2016/7/21.
 */
//应用到对象的属性上
@Target(ElementType.METHOD)
//运行时注入
@Retention(RetentionPolicy.RUNTIME)
public @interface ShopDi {

    String value() default "";
}
