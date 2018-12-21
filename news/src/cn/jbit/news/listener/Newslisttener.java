package cn.jbit.news.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.jbit.news.bean.News;
import cn.jbit.news.newsuserbiz.NewsBiz;
import cn.jbit.news.newsuserbiz.impl.NewsBizImpl;

public class Newslisttener implements HttpSessionListener {
	private NewsBiz biz = new NewsBizImpl();
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		try {
			HttpSession session=arg0.getSession();
			List<News>	list = biz.query_news(null);
			if (list!=null) {
				session.setAttribute("news", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
