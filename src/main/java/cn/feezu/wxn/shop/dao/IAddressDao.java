package cn.feezu.wxn.shop.dao;

import java.util.List;
import cn.feezu.wxn.shop.model.Address;

public interface IAddressDao {
	
	public void add(Address address);
	
	public void delete(int id);
	
	public void update(Address address);
	
	public Address loadById(int id);
	
	public List<Address> loadByUserId(int userId);
}
