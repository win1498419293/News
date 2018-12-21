package cn.jbit.news.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	protected static SqlSession session;
	static {
		try {
			String res="MyBatis-config.xml";
			InputStream fis =Resources.getResourceAsStream(res);
			factory=new SqlSessionFactoryBuilder().build(fis);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		return factory.openSession(false);
	}
	public static void closeSession() {
		try {
			if(session!=null) {
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
