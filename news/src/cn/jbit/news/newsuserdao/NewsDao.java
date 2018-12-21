package cn.jbit.news.newsuserdao;

import java.util.List;

/**
 * 新闻业务
 * @author Administrator
 *
 */
public interface NewsDao {
	/**
	 * 登录
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List login(String sql, Object... params) throws Exception;
	
	/**
	 * 查询所有主题
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List topic_query(String sql,Object...params) throws Exception;
	
	/**
	 * 新闻添加、删除、更新
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int saveOrUpdate(String sql,Object...params) throws Exception;
	/**
	 * 查询新闻
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List news_query(String sql,Object...params) throws Exception;
}
