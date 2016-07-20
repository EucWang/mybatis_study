package cn.feezu.wxn.shop.dao;

import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Pager;
import cn.feezu.wxn.shop.model.User;

public interface IUserDao {
	
	public void add(User user) throws ShopException;
	
	public void delete(int id);
	
	public void update(User user);
	
	public User loadByUsername(String username);
	
	public User load(int id);
	
	public Pager<User> find(String name);
	
	public User login(String username, String password) throws ShopException;

}
