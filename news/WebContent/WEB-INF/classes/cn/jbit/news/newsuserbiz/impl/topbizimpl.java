package cn.jbit.news.newsuserbiz.impl;

import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserbiz.topicbiz;
import cn.jbit.news.newsuserdao.topicdao;
import cn.jbit.news.newsuserdaoimpl.topdaoimpl;

public class topbizimpl implements topicbiz {
	private topicdao top=new topdaoimpl();
	public int topic_add(Topic topic) throws Exception {
		int b1=0;
		try {
			String sql = "insert into topic values(tid,?)";
			Object[] params = {topic.getTname()};
			b1= top.saveOrUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b1;
	}
	@Override
	public List news_topic_find() throws Exception {
	List<News_user> li=null;
	try {
		String sql="select tid,tname from topic order by tid";
		Object[] patmt={};
		li=top.news_topic_find(sql, patmt);
	} catch (Exception e) {
	e.printStackTrace();
	}
		return null;
	}
	@Override
	public int topic_update(Topic topic) throws Exception {
int bl = 0;
		
		try {
			//sql
			String sql = "update topic set tname=? where tid=?";
			//参数解析
			Object[] params = {topic.getTname(),topic.getTid()};
			//修改主题
			bl = top.saveOrUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bl;
	}
	@Override
	public int topic_delete(Topic topic) throws Exception {
int bl = 0;
		
		try {
			//sql
			String sql = "delete from topic where tid=?";
			//参数解析
			Object[] params = {topic.getTid()};
			//修改主题
			bl = top.saveOrUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bl;
	}
	}

