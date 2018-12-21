package cn.jbit.news.newsuserdaoimpl;

import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserdao.topicdao;

public class topdaoimpl extends BaseDao implements topicdao {

	@Override
	public int select(String sql,Object...patmt) throws Exception {
	int b1=0;
	try {
		pstmt=this.exec(sql, patmt);
		b1=pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return  b1;
	}

	@Override
	public List news_topic_find(String sql,Object...patam) throws Exception {
		List  li= new ArrayList();
		try {
			set=this.query(sql,patam);
			while(set.next()) {
				Topic top=new Topic();
				top.setTid(set.getInt("tid"));
				top.setTname(set.getString("tname"));
				li.add(top);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int saveOrUpdate(String sql, Object[] patmt) {
		int b1=0;
		try {
			pstmt=this.exec(sql, patmt);
			b1=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return  b1;
		}
	}


