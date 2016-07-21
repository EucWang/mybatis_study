package cn.feezu.wxn.shop.dao;

/**
 * Created by wangxn on 2016/7/21.
 */
public interface IDaoFactory {
    public Object getDao(String name);
}
