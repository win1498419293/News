package cn.jbit.news.newsuserdaoimpl;

import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Paging;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserdao.NewsDaoMapper;
import cn.jbit.news.util.MyBatisUtil;

public class NewsDaoMapperimpl extends MyBatisUtil implements NewsDaoMapper {

	@Override
	public List query_pag(Paging pag) throws Exception {
		List li=null;
		try {
			session=this.getSession();
			NewsDaoMapper  userMapper=session.getMapper(NewsDaoMapper.class);
			li=userMapper.query_pag(pag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List login(News_user user) throws Exception {
		List li=null;
		try {
			session=this.getSession();
			NewsDaoMapper  userMapper=session.getMapper(NewsDaoMapper.class);
			li=userMapper.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List topic_query(Topic top) throws Exception {
		List li=null;
		try {
			session=this.getSession();
			NewsDaoMapper  userMapper=session.getMapper(NewsDaoMapper.class);
			li=userMapper.topic_query(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int saveOrUpdate(Topic top) throws Exception {
		int li=0;
		try {
			session=this.getSession();
			NewsDaoMapper  userMapper=session.getMapper(NewsDaoMapper.class);
			li=userMapper.saveOrUpdate(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public List news_query(Topic top) throws Exception {
		List li=null;
		try {
			session=this.getSession();
			NewsDaoMapper  userMapper=session.getMapper(NewsDaoMapper.class);
			li=userMapper.topic_query(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
}
