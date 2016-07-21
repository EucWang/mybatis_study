package cn.feezu.wxn.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.feezu.wxn.shop.dao.*;
import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Address;
import cn.feezu.wxn.shop.model.User;
import cn.feezu.wxn.shop.util.DaoUtil;

public class AddressDao extends BaseDao<Address> implements IAddressDao  {
private IUserDao userDao;

// 
//	public void add(Address address){
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.openSession();
//			session.insert(Address.class.getName() + ".add", address);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//	} 
	
	public AddressDao(){
		userDao = (IUserDao) DaoUtil.getDaoFactory().getDao("userdao");
	}
	 
	public void add(Address address, int userId) throws ShopException{
		User user = userDao.load(userId);
		if (user == null) {
			throw new ShopException("添加地址的用户不存在!");
		}
		
		address.setUser(user);
		super.add(address);
	}

	/**
	 * 删除用户
	 */
	public void delete(int id) {
//		SqlSession session = null;
//
//		try {
//			session = MyBatisUtil.openSession();
//			session.delete(Address.class.getName() + ".delete", id);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
		super.delete(Address.class, id);
	}

	public void update(Address address) {
//		SqlSession session = null;
//
//		try {
//			session = MyBatisUtil.openSession();
//			session.update(Address.class.getName() + ".update", address);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
		super.update(address);
	}

	public Address load(int id) {
//		SqlSession session = null;
//		Address address = null;
//		try {
//			session = MyBatisUtil.openSession();
//			address = session.selectOne(Address.class.getName() + ".load_by_addressname", id);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//		
//		return address;
		return super.load(Address.class, id);
	}

	public List<Address> loadByUserId(int userId) {
//		SqlSession session = null;
//		List<Address> addresses = null;
//		try { 
//			session = MyBatisUtil.openSession();
//			addresses = session.selectList(Address.class.getName() + ".load_by_user_id", userId);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//		
//		return addresses;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return super.list(Address.class +".load_by_user_id", params);
	}

}
