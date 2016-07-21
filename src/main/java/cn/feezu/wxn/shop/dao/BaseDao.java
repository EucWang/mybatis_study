package cn.feezu.wxn.shop.dao;

import cn.feezu.wxn.shop.model.Pager;
import cn.feezu.wxn.shop.model.SystemContext;
import cn.feezu.wxn.shop.util.DaoUtil;
import cn.feezu.wxn.shop.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao<T> {



    public BaseDao() {
        DaoUtil.injectDao(this);
    }


    public void add(T obj) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            session.insert(obj.getClass().getName() + ".add", obj);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }

    public void update(T obj) {
        SqlSession session = null;

        try {
            session = MyBatisUtil.openSession();
            session.update(obj.getClass().getName() + ".update", obj);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }

    }

    public void delete(Class<T> clazz, int id) {
        SqlSession session = null;

        try {
            session = MyBatisUtil.openSession();
            session.delete(clazz.getName() + ".delete", id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }

    public T load(Class<T> clazz, int id) {
        return this.loadByQueryName(clazz.getName() + ".load", id);
    }

    public T loadByQueryName(String queryName, Map<String, Object> params) {
        SqlSession session = null;
        T obj = null;
        try {
            session = MyBatisUtil.openSession();
            obj = session.selectOne(queryName, params);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }

        return obj;
    }

    public T loadByQueryName(String queryName, Object obj) {
        SqlSession session = null;
        T retVal = null;
        try {
            session = MyBatisUtil.openSession();
            retVal = session.selectOne(queryName, obj);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }

        return retVal;
    }

    public Pager<T> find(Class<T> clazz, Map<String, Object> params) {
        return this.find(clazz.getName() + ".find", params);
    }

    public Pager<T> find(String queryName, Map<String, Object> params) {

        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffset();
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Pager<T> pages = new Pager<T>();
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();

            if (params == null) {
                params = new HashMap<String, Object>();
            }

            params.put("pageSize", pageSize);
            params.put("pageOffset", pageOffset);
            params.put("order", order);
            params.put("sort", sort);

            List<T> objs = session.selectList(queryName, params);
            pages.setDatas(objs);
            pages.setPageOffset(pageOffset);
            pages.setPageSize(pageSize);

            int totalRecord = session.selectOne(queryName + "_count", params);
            pages.setTotalRecord(totalRecord);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
        return pages;
    }

    public List<T> list(Class<T> clazz, Map<String, Object> params) {
        return this.list(clazz.getName() + ".list", params);
    }

    public List<T> list(String queryName, Map<String, Object> params) {
        List<T> list = null;
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            list = session.selectList(queryName, params);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }

        return list;
    }
}
