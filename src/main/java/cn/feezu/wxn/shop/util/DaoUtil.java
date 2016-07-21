package cn.feezu.wxn.shop.util;

import cn.feezu.wxn.shop.dao.IDaoFactory;
import cn.feezu.wxn.shop.util.PropertiesUtil;

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


}
