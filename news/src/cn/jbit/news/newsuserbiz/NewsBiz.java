package cn.jbit.news.newsuserbiz;

import java.util.List;

import cn.jbit.news.bean.News;
import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;

/**
 * 新闻业务处理
 * @author Administrator
 *
 */
public interface NewsBiz {
	/**
	 * 新闻用户登录
	 * @param user 新闻用户对象
	 * @return 整型
	 * @throws Exception
	 */
	int news_login(News_user user) throws Exception;
	
	/**
	 * 查询主题
	 * @return
	 * @throws Exception
	 */
	List news_topic_find() throws Exception;
	
	/**
	 * 新闻添加
	 * @param news
	 * @return
	 * @throws Exception
	 */
	int news_add(News news) throws Exception;
	List query_news(Topic topic) throws Exception;
	
	/**
	 * 查询新闻对象
	 * @param news
	 * @return
	 * @throws Exception
	 */
	List query_news_obj(News news) throws Exception;
	
	/**
	 * 新闻更新闻
	 * @param news
	 * @return
	 * @throws Exception
	 */
	int news_update(News news) throws Exception;
}
