package cn.jbit.news.newsuserdao;

import java.util.List;

import cn.jbit.news.bean.Topic;

public interface topicdaoMapper {
	int select(Topic top)throws Exception;
	int saveOrUpdate(Topic top); 
	List news_topic_find(Topic top) throws Exception;
}
