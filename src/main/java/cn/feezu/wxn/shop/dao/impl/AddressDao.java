package cn.feezu.wxn.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.model.Address;
import cn.feezu.wxn.shop.util.MyBatisUtil;

public class AddressDao implements IAddressDao {
 
	public void add(Address address){
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			session.insert(Address.class.getName() + ".add", address);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			 MyBatisUtil.closeSession(session); 
		}
	} 

	/**
	 * 删除用户
	 */
	public void delete(int id) {
		SqlSession session = null;

		try {
			session = MyBatisUtil.openSession();
			session.delete(Address.class.getName() + ".delete", id);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			 MyBatisUtil.closeSession(session); 
		}
	}

	public void update(Address address) {
		SqlSession session = null;

		try {
			session = MyBatisUtil.openSession();
			session.update(Address.class.getName() + ".update", address);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			 MyBatisUtil.closeSession(session); 
		}
		 
	}

	public Address loadById(int id) {
		SqlSession session = null;
		Address address = null;
		try {
			session = MyBatisUtil.openSession();
			address = session.selectOne(Address.class.getName() + ".load_by_addressname", id);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			 MyBatisUtil.closeSession(session); 
		}
		
		return address;
	}

	public List<Address> loadByUserId(int userId) {
		SqlSession session = null;
		List<Address> addresses = null;
		try {
			session = MyBatisUtil.openSession();
			addresses = session.selectList(Address.class.getName() + ".load_by_user_id", userId);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			 MyBatisUtil.closeSession(session); 
		}
		
		return addresses;
	}

}
