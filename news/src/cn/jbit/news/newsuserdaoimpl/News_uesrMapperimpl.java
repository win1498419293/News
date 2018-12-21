package cn.jbit.news.newsuserdaoimpl;

import java.util.List;

import cn.jbit.news.bean.Paging;
import cn.jbit.news.newsuserdao.NewsDaoMapper;
import cn.jbit.news.util.MyBatisUtil;

public class News_uesrMapperimpl extends MyBatisUtil {
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
}
