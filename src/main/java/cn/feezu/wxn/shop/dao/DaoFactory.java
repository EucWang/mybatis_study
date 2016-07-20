package cn.feezu.wxn.shop.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class DaoFactory {
	private static Properties properties;
  
	
	static{
		properties = new Properties();
		InputStream inStream = DaoFactory.class.getResourceAsStream("dao.properties");
		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IUserDao getUserDao() {
		String userDaoClassName = properties.getProperty("userdao");
		try {
			Class<?> dao = Class.forName(userDaoClassName);
			return (IUserDao) dao.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static IAddressDao getAddressDao() {
		String addressDaoClassName = properties.getProperty("addressDao");
		try {
			Class<?> dao = Class.forName(addressDaoClassName);
			return (IAddressDao) dao.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
