package cn.feezu.wxn.shop.dao.impl;

import java.util.Map;

import cn.feezu.wxn.shop.dao.BaseDao;
import cn.feezu.wxn.shop.dao.IMerchandiseDao;
import cn.feezu.wxn.shop.model.Merchandise;
import cn.feezu.wxn.shop.model.Pager;

public class MerchandiseDao extends BaseDao<Merchandise> implements IMerchandiseDao {

	public void add(Merchandise merchandise) {
		super.add(merchandise);
	}

	public void delete(int id) {
		super.delete(Merchandise.class, id);
	}

	public void update(Merchandise merchandise) {
		super.update(merchandise);
	}

	public Merchandise load(int id) {
		return super.load(Merchandise.class, id);
	}

	public Pager<Merchandise> find(Map<String, Object> params) {
		return super.find(Merchandise.class, params);
	}
 
}
