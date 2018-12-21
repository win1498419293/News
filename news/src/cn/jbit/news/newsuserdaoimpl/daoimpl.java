package cn.jbit.news.newsuserdaoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserdao.newsuserdao;

public class daoimpl extends BaseDao implements newsuserdao {
	private Connection con;
	protected PreparedStatement pstmt;
	public PreparedStatement exec(String sql,News_user nnr) throws Exception {
		con=this.getCon();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,nnr.getUserName());
		pstmt.setString(2, nnr.getPassword());
		pstmt.setString(3, nnr.getEmail());
		pstmt.setInt(4, nnr.getUserType());
		return pstmt;
		
	}
	public PreparedStatement upde(String sql,Object...patmt) throws Exception {
		con=this.getCon();
		for(int i=0;i<patmt.length;i++) {
			pstmt.setObject(i+1, patmt[i]);
		}
		return pstmt;
	}
	public int seve(String sql, News_user nnr) throws Exception {
		int b1=0;
		try {
			pstmt=this.exec(sql, nnr);
			b1=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.destory();
		}
		return b1;
	}
	@Override
	public List login(String sql,Object...patmt) throws Exception {
		List li=new ArrayList();
		try {
			set=this.query(sql, patmt);
			while (set.next()) {
				News_user unr=new News_user();
				unr.setId(set.getInt("id"));
				unr.setUserName(set.getString("userName"));
				unr.setPassword(set.getString("password"));
				li.add(unr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		return li;
	}
	public int delete(String sql, Object...patmt) throws Exception {
		int b1=0;
		try {
			pstmt=this.upde(sql, patmt);
			b1=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.destory();
		}
		return b1;
	}
	public int update(String sql, Object...patmt) throws Exception {
		int b1=0;
		try {
			
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			this.destory();
		}
		return b1;
	}

}
