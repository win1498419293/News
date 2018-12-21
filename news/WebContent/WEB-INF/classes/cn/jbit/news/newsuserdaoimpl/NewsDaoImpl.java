package cn.jbit.news.newsuserdaoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.jbit.news.newsuserdao.NewsDao;
import cn.jbit.news.bean.News;
import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List login(String sql, Object... params) throws Exception {
		//集合
		List list = new ArrayList();
		try {
			//查询
			set = this.query(sql, params);
			//遍历
			while(set.next()) {
				//对象
				News_user user = new News_user();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		//返回
		return list;
	}
	
	/**
	 * 查询新闻主题
	 */
	@Override
	public List topic_query(String sql, Object... params) throws Exception {
		//集合
		List list = new ArrayList();
		try {
			//查询
			set = this.query(sql, params);
			//遍历
			while(set.next()) {
				//对象
				Topic topic = new Topic();
				topic.setTid(set.getInt("tid"));
				topic.setTname(set.getString("tname"));

				//添加对象
				list.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		//返回
		return list;
	}
	
	/**
	 * 新闻添加、删除、更新
	 */
	@Override
	public int saveOrUpdate(String sql, Object... params) throws Exception {
		//标准
		int bl = 0;
		try {
			//预编译(执行sql,参数解析)
			pstmt = this.exec(sql, params);
			//添加
			bl = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		//返回
		return bl;
	}

	@Override
	public List news_query(String sql, Object... params) throws Exception {
		List list = new ArrayList();
		try {
			//查询
			set = this.query(sql, params);
			//遍历
			while(set.next()) {
				//对象
				News news = new News();
				news.setNid(set.getInt("nid"));
				news.setNtid(set.getInt("ntid"));
				news.setNtitle(set.getString("ntitle"));
				news.setNauthor(set.getString("nauthor"));
				news.setNcreatedate(set.getDate("ncreatedate"));
				news.setNpicpath(set.getString("npicpath"));
				news.setNcontent(set.getString("ncontent"));
				news.setNmodifydate(set.getDate("nmodifydate"));
				news.setNsummary(set.getString("nsummary"));
				//添加对象
				list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		//返回
		return list;
	}
	}


