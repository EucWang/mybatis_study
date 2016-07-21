package cn.feezu.wxn.shop.dao.impl;

import org.junit.Before;
import org.junit.Test;

import cn.feezu.wxn.shop.dao.DaoFactory;
import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Address;

public class TestAddressDao {
	private IAddressDao addressDao;

	@Before
	public void init(){
		addressDao = DaoFactory.getAddressDao();		
	}
	
	@Test
	public void testAdd(){
//		Address address = newAddress("林肯街15号,火星区,太阳市", "15714521547", "443322", "橙色小摩托");
		Address address = newAddress("重庆街15号,武汉区,阿布拉市", "13552713017", "123456", "扬帆起航");
		
		//User loadByUsername = DaoFactory.getUserDao().loadByUsername("zhangsan");
		
		//address.setUser(loadByUsername);
		try {
			addressDao.add(address , 6);
		} catch (ShopException e) {
			e.printStackTrace();
		}
	}

	private Address newAddress(String name, String phone, String postcode, String receiver) {
		Address address = new Address();
		address.setName(name);
		address.setPhone(phone);
		address.setPostcode(postcode);
		address.setReceiveUser(receiver);
		return address;
	}

	
	@Test
	public void testLoad(){
		Address address = addressDao.load(1);
		System.out.println(address);
	}
        
}
