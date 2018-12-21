package cn.jbit.news.newsuserdao;

import java.util.List;

import cn.jbit.news.bean.Topic;

public interface topicdao {
	int select(String sql,Object...patmt)throws Exception;
	int saveOrUpdate(String sql, Object[] params); 
	List news_topic_find(String sql,Object...patmt) throws Exception;
}
