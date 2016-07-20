package cn.feezu.wxn.shop.dao.impl;
 
import java.util.HashMap;
import java.util.Map;

import cn.feezu.wxn.shop.dao.BaseDao;
import cn.feezu.wxn.shop.dao.IUserDao;
import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Pager;
import cn.feezu.wxn.shop.model.User;

public class UserDao extends BaseDao<User> implements IUserDao {
 
//	public void add(User user) throws ShopException {
//		
//		User loadByUsername = this.loadByUsername(user.getUsername());
//		if (loadByUsername != null) {
//			throw new ShopException("要添加的用户已存在");
//		}
//		
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.openSession();
//			session.insert(User.class.getName() + ".add", user);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//	} 

	/**
	 * 删除用户
	 */
	public void delete(int id) {
//		SqlSession session = null;
//
//		try {
//			session = MyBatisUtil.openSession();
//			session.delete(User.class.getName() + ".delete", id);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
		super.delete(User.class, id);
		
	}

	public void update(User user) {
//		SqlSession session = null;
//
//		try {
//			session = MyBatisUtil.openSession();
//			session.update(User.class.getName() + ".update", user);
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
		//TODO 需要先删除关联的对象
		super.update(user); 
	}

	public User loadByUsername(String username) {
//		SqlSession session = null;
//		User user = null;
//		try {
//			session = MyBatisUtil.openSession();
//			
//			user = session.selectOne(User.class.getName() + ".load_by_username", username);
//			
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//		
//		return user;
		return super.loadByQueryName(User.class.getName() +".load_by_username", username);
	}

	public User load(int id) {
//		SqlSession session = null;
//		User user = null;
//		try {
//			session = MyBatisUtil.openSession();
//			
//			user = session.selectOne(User.class.getName() + ".load", id);
//			
//			session.commit();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 MyBatisUtil.closeSession(session); 
//		}
//		
//		return user;
		return super.load(User.class, id);
	}

	public Pager<User> find(String name) {
//		int pageSize = SystemContext.getPageSize();
//		int pageOffset = SystemContext.getPageOffset();
//		String order = SystemContext.getOrder();
//		String sort = SystemContext.getSort();
//		Pager<User> pages = new Pager<User>();
//		SqlSession session = null;
//		try {
//			session = MyBatisUtil.openSession();
//			
//			Map<String, Object> params = new HashMap<String, Object>();
//			if (name != null && !"".equals(name)) {
//				params.put("name", "%" +name+"%"); 				
//			}
////			params.put("type", 1);
//			
//			params.put("pageSize", pageSize);
//			params.put("pageOffset", pageOffset);
//			params.put("order", order);
//			params.put("sort", sort);
//			
//			List<User> users = session.selectList(User.class.getName() + ".find", params);
//			pages.setDatas(users);
//			pages.setPageOffset(pageOffset);
//			pages.setPageSize(pageSize);
//			
//			int totalRecord = session.selectOne(User.class.getName() + ".find_count", params);
//			pages.setTotalRecord(totalRecord);
//			
//			session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			MyBatisUtil.closeSession(session);
//		}
//		return pages;
		
		Map<String, Object> params = new HashMap<String, Object>();
		if (name != null && !"".equals(name)) {
			params.put("name", "%" + name + "%");
		}
		
		return super.find(User.class, params);
	}

	public User login(String username, String password) throws ShopException {
		
		User loadByUsername = this.loadByUsername(username);
		if (loadByUsername == null) {
			throw new ShopException("用户名不存在");
		}
		
		if (!password.equals(loadByUsername.getPassword())) {
			throw new ShopException("密码不正确");
		}
		
		return loadByUsername;
	}

}
