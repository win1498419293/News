package cn.jbit.news.newsuserbiz.impl;

import java.util.List;

import cn.jbit.news.newsuserbiz.NewsBiz;
import cn.jbit.news.newsuserdao.NewsDao;
import cn.jbit.news.newsuserdaoimpl.NewsDaoImpl;
import cn.jbit.news.bean.News;
import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;

/**
 * 新闻业务
 * @author Administrator
 *
 */
public class NewsBizImpl implements NewsBiz {
	//数据层
	private NewsDao ndao = new NewsDaoImpl();
	
	/**
	 * 新闻登录
	 */
	@Override
	public int news_login(News_user user) throws Exception {
		//标准
		int bl = 0;
		
		try {
			//sql
			String sql = "select id,username,password from news_user where username=?";
			//参数封装(用户名)
			Object[] params = {user.getUserName()};
			//集合
			List<News_user> list = ndao.login(sql, params);
			//判断
			if(list!=null) {
				for(News_user li : list) {
					if(li.getPassword().equals(user.getPassword())) {
						//登录成功
						bl = 1;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bl;
	}
	
	/**
	 * 查询新闻主题
	 */
	@Override
	public List news_topic_find() throws Exception {
		//集合
		List<News_user> list = null;
		
		try {
			//sql
			String sql = "select tid,tname from topic order by tid";
			//参数封装(用户名)
			Object[] params = {};
			//集合
			list = ndao.topic_query(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 新闻添加
	 */
	@Override
	public int news_add(News news) throws Exception {
		//标准
		int bl = 0;
		
		try {
			//sql
			String sql = "insert into news values(nid,?,null,null,?,?,now(),?,?,null,?)";
			//参数封装(用户名)
			Object[] params = {
					news.getNtid(),
					news.getNtitle(),
					news.getNauthor(),
					news.getNpicpath(),
					news.getNcontent(),
					news.getNsummary()
					};
			//添加
			bl = ndao.saveOrUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bl;
	}

	@Override
	public List query_news(Topic topic) throws Exception {
List list = null;
		
		try {
			//sql
			String sql = null;
			//参数
			Object[] params = null;
			if(topic==null) {
				sql = "select nid,ntid,ntitle,nauthor,ncreatedate,npicpath,ncontent,nmodifydate,nsummary from news order by nid desc";
				//参数封装(用户名)
				params = new Object[]{};
			}
			else {
				//sql
				sql = "select nid,ntid,ntitle,nauthor,ncreatedate,npicpath,ncontent,nmodifydate,nsummary from news where ntid=? order by nid desc";
				//参数封装(用户名)
				params = new Object[]{topic.getTid()};	
			}
			//集合
			list = ndao.news_query(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List query_news_obj(News news) throws Exception {
		List list = null;
		try {
			//sql
			String sql = "select nid,ntid,ntitle,nauthor,ncreatedate,"
					+ "npicpath,ncontent,nmodifydate,"
					+ "nsummary from news where nid=?";
			//封装
			Object[] params = {news.getNid()};
			//集合
			list = ndao.news_query(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回
		return list;
	}

	@Override
	public int news_update(News news) throws Exception {
int bl = 0;
		
		try {
			//sql
			String sql = "update news set ntitle=?,nauthor=?,npicpath=?,ncontent=?,nmodifydate=now(),nsummary=? where nid=?";
			//参数封装(用户名)
			Object[] params = {
					news.getNtitle(),
					news.getNauthor(),
					news.getNpicpath(),
					news.getNcontent(),
					news.getNsummary(),
					news.getNid()
					};
			//添加
			bl = ndao.saveOrUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bl;
	}
	}
	