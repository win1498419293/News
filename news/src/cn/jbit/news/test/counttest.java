package cn.jbit.news.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class counttest {
	private static Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String resource = "MyBatis-config.xml";
		//文件流
		InputStream fis = Resources.getResourceAsStream(resource);
		//会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(fis);
		//会话
		SqlSession session = factory.openSession();
		//统计查询的结果
		int count = session.selectOne("find_count");
		//输出
		logger.debug("统计主题数量:"+count);
		//会话
		session.close();
	}

}
