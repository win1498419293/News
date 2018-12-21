package cn.jbit.news.newsuserbiz;

import java.util.List;

import cn.jbit.news.bean.Topic;

public interface topicbiz {
	int topic_add(Topic topic) throws Exception;
	List news_topic_find() throws Exception;
	int topic_update(Topic topic) throws Exception;
	int topic_delete(Topic topic) throws Exception;
}
