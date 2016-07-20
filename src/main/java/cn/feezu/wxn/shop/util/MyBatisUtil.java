package cn.feezu.wxn.shop.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory FACTORY;
 
	
	static {
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		return FACTORY.openSession();
	}

	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
