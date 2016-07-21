package cn.feezu.wxn.shop.dao.impl;

import org.junit.Before;
import org.junit.Test;

import cn.feezu.wxn.shop.dao.DaoFactory;
import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.dao.IUserDao;
import cn.feezu.wxn.shop.model.Address;
import cn.feezu.wxn.shop.model.User;

public class TestAddressDao {
	private IAddressDao addressDao;

	@Before
	public void init(){
		addressDao = DaoFactory.getAddressDao();		
	}
	
	@Test
	public void testAdd(){
		Address address = new Address();
		address.setName("林肯街15号,火星区,太阳市");
		address.setPhone("15714521547");
		address.setPostcode("443322");
		address.setReceiveUser("橙色小摩托");
		
		//User loadByUsername = DaoFactory.getUserDao().loadByUsername("zhangsan");
		
		//address.setUser(loadByUsername);
		addressDao.add(address , 6);
	}

             @Test
             public void testLoad(){
                        Address address = addressDao.load(1);
             }
}
