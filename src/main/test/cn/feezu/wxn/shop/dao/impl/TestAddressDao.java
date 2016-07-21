package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.util.DaoUtil;
import org.junit.Before;
import org.junit.Test;

import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.model.Address;

public class TestAddressDao {
    private IAddressDao addressDao;

    @Before
    public void init() {
        addressDao = (IAddressDao) DaoUtil.getDaoFactory().getDao("addressdao");
    }

    @Test
    public void testAdd() {
        Address address = new Address();
        address.setName("林肯街15号,火星区,太阳市");
        address.setPhone("15714521547");
        address.setPostcode("443322");
        address.setReceiveUser("橙色小摩托");

        //User loadByUsername = JDBCDaoFactory.getUserDao().loadByUsername("zhangsan");

        //address.setUser(loadByUsername);
        try {
            addressDao.add(address, 6);
        } catch (ShopException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoad() {
        Address address = addressDao.load(1);
        System.out.println(address);
    }
}
