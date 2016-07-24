package cn.feezu.wxn.shop.dao;

import java.util.Map;

import cn.feezu.wxn.shop.model.Merchandise;
import cn.feezu.wxn.shop.model.Pager;

public interface IMerchandiseDao {
	
	public void add(Merchandise merchandise);
	
	public void delete(int id);
	
	public void update(Merchandise merchandise);
	
	public Merchandise load(int id);
	
	public Pager<Merchandise> find(Map<String, Object> params);
}
