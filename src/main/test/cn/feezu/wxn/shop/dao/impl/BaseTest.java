package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.util.DaoUtil;

/**
 * Created by wangxn on 2016/7/21.
 */
public class BaseTest {
    public BaseTest(){
        DaoUtil.injectDao(this);
    }
}
