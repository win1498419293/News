package cn.jbit.news.newsuserdaoimpl;

import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.bean.Comment;
import cn.jbit.news.bean.News_user;
import cn.jbit.news.newsuserdao.NewsRegDao;

public class NewsRegDaoimpl extends BaseDao implements NewsRegDao {

	@Override
	public List query_pag(String sql, Object... params) throws Exception {
		List list=new ArrayList();
		try {
			set=this.query(sql, params);
			while(set.next()) {
				News_user user=new News_user();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("userName"));
				user.setPassword(set.getString("password"));
				user.setEmail(set.getString("email"));
				user.setUserType(set.getInt("userType"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.destory();
		}
		return list;
	}

	@Override
	public int page_max(String sql,Object...patmt) throws Exception {
		int b1=0;
		try {
			set=this.query(sql, patmt);
			while(set.next()) {
				b1=set.getInt("sun");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.destory();
		}
		return b1;
	}

	@Override
	public List query_comment(String sql, Object... params) throws Exception {
		List list=new ArrayList();
		try {
			set=this.query(sql, params);
			while(set.next()) {
				Comment comm=new Comment();
				comm.setCid(set.getInt("cid"));
				comm.setCnid(set.getInt("cnid"));
				comm.setCconent(set.getString("cconent"));
				comm.setCdate(set.getDate("cdate"));
				comm.setCip(set.getString("cip"));
				comm.setCauth(set.getString("cauth"));
				list.add(comm);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.destory();
		}
		return list;
	}

	@Override
	public int commadd(String sql, Object... params) throws Exception {
		int bl = 0;
		try {
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

}
