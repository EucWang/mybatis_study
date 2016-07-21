package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.dao.IDaoFactory;
import cn.feezu.wxn.shop.dao.IUserDao;
import cn.feezu.wxn.shop.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCDaoFactory implements IDaoFactory {

    private JDBCDaoFactory() {}

    private static JDBCDaoFactory instance;

    public static JDBCDaoFactory getInstance() {
        if (instance == null) {
            instance = new JDBCDaoFactory();
        }
        return instance;
    }

    public Object getDao(String daoName) {
        Properties daoProperties = PropertiesUtil.getDaoProperties();
        Object dao =  PropertiesUtil.getObj(daoProperties, daoName);
        if (dao != null) return dao;
        return null;
    }
}
