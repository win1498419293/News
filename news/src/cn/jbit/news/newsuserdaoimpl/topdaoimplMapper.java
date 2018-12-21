package cn.jbit.news.newsuserdaoimpl;

import java.util.List;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserdao.NewsDaoMapper;
import cn.jbit.news.newsuserdao.topicdaoMapper;
import cn.jbit.news.util.MyBatisUtil;

public class topdaoimplMapper extends MyBatisUtil implements  topicdaoMapper {

	@Override
	public int select(Topic top) throws Exception {
		int li=0;
		try {
			session=this.getSession();
			topicdaoMapper  userMapper=session.getMapper(topicdaoMapper.class);
			li=userMapper.select(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int saveOrUpdate(Topic top) {
		int li=0;
		try {
			session=this.getSession();
			topicdaoMapper  userMapper=session.getMapper(topicdaoMapper.class);
			li=userMapper.saveOrUpdate(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List news_topic_find(Topic top) throws Exception {
		List li=null;
		try {
			session=this.getSession();
			topicdaoMapper  userMapper=session.getMapper(topicdaoMapper.class);
			li=userMapper.news_topic_find(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
