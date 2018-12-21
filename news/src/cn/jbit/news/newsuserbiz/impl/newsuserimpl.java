package cn.jbit.news.newsuserbiz.impl;
import java.security.UnrecoverableEntryException;
import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserdao.newsuserdao;
import cn.jbit.news.newsuserbiz.newsuserbiz;
import cn.jbit.news.newsuserdaoimpl.daoimpl;
public class newsuserimpl implements newsuserbiz {
	private newsuserdao dao=new daoimpl();
	public int user_add( News_user nur) throws Exception {
		int b1=0; 
		try {
		 String	sql="insert into News_user values(id,?,?,?,?)";
		b1=dao.seve(sql, nur);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}
	@Override
	public int login(News_user nur) throws Exception {
		int b1=0;
		try {
			String sql="select id,username,password from news_user where username=?";
			Object [] patmt= {nur.getUserName()};
			List<News_user> li= dao.login(sql, patmt);
			if (li!=null) {
				for(News_user list:li) {
					if (list.getPassword().equals(nur.getPassword())) {
						b1=1;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b1;
	}
	@Override
	public int user_dele(Topic top) throws Exception {
		int b1=0;
		try {
			String sql="delete from topic WHERE tid=?";
			Object [] patmt= {top.getTid()};
			dao.update(sql, patmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}
	@Override
	public int user_upda(Topic top) throws Exception {
		int b1=0;
		try {
			String sql="UPDATE topic SET tname=?  WHERE tid=?";
			Object[] patmt= {top.getTname(),top.getTid()};
			dao.update(sql, patmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}

}
