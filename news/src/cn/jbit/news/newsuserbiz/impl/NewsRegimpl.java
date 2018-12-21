package cn.jbit.news.newsuserbiz.impl;

import java.util.List;

import cn.jbit.news.bean.Comment;
import cn.jbit.news.bean.Paging;
import cn.jbit.news.newsuserbiz.NewsRegbiz;
import cn.jbit.news.newsuserdao.NewsRegDao;
import cn.jbit.news.newsuserdaoimpl.NewsRegDaoimpl;

public class NewsRegimpl implements NewsRegbiz {
	private NewsRegDao rdao = new NewsRegDaoimpl();

	@Override
	public List news_paging(Paging pag) throws Exception {
			List list = null;
		try {
			String sql = "select id,userName,password,email,userType from news_user limit ?,?";
			//参数封装
			Object[] params = {pag.getStart(),pag.getCou_rec()};
			//分页查询
			list = rdao.query_pag(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int page_max() throws Exception {
		int b1=0;
		try {
			String sql="select count(*) sun from news_user";
			Object [] params= {};
			b1=rdao.page_max(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public List news_urse_query() throws Exception {
		List li=null;
		try {
			String sql="select id,userName,password,email,userType from news_user";
			Object [] params= {};
			li=rdao.query_pag(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List comment_query(Comment comm) throws Exception {
		List li=null;
		try {
			String sql="SELECT  cid,cnid,cconent,cdate,cip,cauth FROM COMMENT WHERE cnid=?";
			Object [] params= {comm.getCnid()};
			li=rdao.query_comment(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int addcomm(Comment comm) throws Exception {
		int b1=0;
		try {
			String sql="INSERT INTO  `COMMENT` VALUES(cid,?,?,NOW(),?,?)";
			Object [] params= {comm.getCnid(),comm.getCconent(),comm.getCip(),comm.getCauth()};
			b1=rdao.commadd(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}
}

