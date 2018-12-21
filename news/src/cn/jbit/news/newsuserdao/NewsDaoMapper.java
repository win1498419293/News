package cn.jbit.news.newsuserdao;

import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Paging;
import cn.jbit.news.bean.Topic;

public interface NewsDaoMapper {
	List  query_pag(Paging pag)throws Exception;
		public List login(News_user user) throws Exception;
		
		/**
		 * 查询所有主题
		 * @param sql
		 * @param params
		 * @return
		 * @throws Exception
		 */
		List topic_query(Topic top) throws Exception;
		
		/**
		 * 新闻添加、删除、更新
		 * @param sql
		 * @param params
		 * @return
		 * @throws Exception
		 */
		int saveOrUpdate(Topic top) throws Exception;
		/**
		 * 查询新闻
		 * @param sql
		 * @param params
		 * @return
		 * @throws Exception
		 */
		List news_query(Topic top) throws Exception;
}
