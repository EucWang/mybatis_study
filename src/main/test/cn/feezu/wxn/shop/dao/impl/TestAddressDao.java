package cn.feezu.wxn.shop.dao.impl;

import cn.feezu.wxn.shop.dao.IAddressDao;
import cn.feezu.wxn.shop.exception.ShopException;
import cn.feezu.wxn.shop.model.Address;
import cn.feezu.wxn.shop.model.ShopDi;
import cn.feezu.wxn.shop.dao.impl.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class TestAddressDao extends BaseTest {


    private IAddressDao addressDao;

    public IAddressDao getAddressDao() {
        return addressDao;
    }

    @ShopDi
    public void setAddressDao(IAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Before
    public void init() {
//        addressDao = (IAddressDao) DaoUtil.getDaoFactory().getDao("addressDao");
    }

    @Test
    public void testAdd() {
        Address address = new Address();
        address.setName("刀郎街15号,金星区,半人马市");
        address.setPhone("15712345678");
        address.setPostcode("234234");
        address.setReceiveUser("橙色大飞机");

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
