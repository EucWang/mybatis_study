package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.model.ShopDi;
import cn.feezu.wxn.shop.util.DaoUtil;
import org.junit.Before;
import org.junit.Test;
import cn.feezu.wxn.shop.dao.IUserDao;
import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Pager;
import cn.feezu.wxn.shop.model.SystemContext;
import cn.feezu.wxn.shop.model.User;

public class TestUserDao extends BaseTest {
	private IUserDao userDao;


	public IUserDao getUserDao() {
		return userDao;
	}
	@ShopDi
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Before
	public void init(){
//		userDao = (IUserDao) DaoUtil.getDaoFactory().getDao("userDao");
	}

	@Test
	public void testAdd() {
 
//		User user = getUser("zhangfei", "feifei", "123321",1);
//		User user = getUser("zhangfei", "feifei", "123321",1);
//		User user = getUser("zhangfei", "feifei", "123321",1);
		User user = getUser("zhubajie", "猪八戒", "654321",1);

		try {
			userDao.add(user);
		} catch (ShopException e) {
			e.printStackTrace();
		}
	}

	private User getUser(String name, String nickname, String pwd, int type) {
		User user = new User();
		user.setUsername(name);
		user.setNickname(nickname);
		user.setPassword(pwd);
		user.setType(type);
		return user;
	}
	
	@Test
	public void testUpdate(){
		User user = userDao.loadByUsername("zhangsan");
		user.setType(3);
		userDao.update(user);
	}
	
	@Test
	public void testDelete(){
//		for (int i=7; i<12; i++){
			userDao.delete(12);
//		}
	}

	
	@Test
	public void testLogin(){
		User user = null;
		try {
			user = userDao.login("zhangsan", "123123");
		} catch (ShopException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		if (user != null) {
			System.out.println("登陆成功");
		}
	}
	
	@Test
	public void testFind(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(15);
//		SystemContext.setSort("username");
//		SystemContext.setOrder("desc");
		Pager<User> find = userDao.find("zhang");
		System.out.println(find.getTotalRecord());
		for(User user : find.getDatas()){
			System.out.println(user.toString());
		}
	}
}
