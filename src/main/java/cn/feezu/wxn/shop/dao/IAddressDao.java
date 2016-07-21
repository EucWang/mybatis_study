package cn.feezu.wxn.shop.dao;

import java.util.List;

import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Address;

public interface IAddressDao {
	
	public void add(Address address, int userId) throws ShopException;
	
	public void delete(int id);
	
	public void update(Address address);
	
	public Address load(int id);
	
	public List<Address> loadByUserId(int userId);
}
