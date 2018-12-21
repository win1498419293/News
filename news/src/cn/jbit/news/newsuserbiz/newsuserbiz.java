package cn.jbit.news.newsuserbiz;
import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;

public interface newsuserbiz {
	/**
	 * 添加
	 * @param nur
	 * @return
	 * @throws Exception
	 */
	int user_add(News_user nur) throws Exception;
	/**
	 * 登陆
	 * @param nur
	 * @return
	 * @throws Exception
	 */
	int login(News_user nur) throws Exception;
	/**
	 * 删除
	 * @param nur
	 * @return
	 * @throws Exception
	 */
	int user_dele(Topic top)throws Exception;
	/**
	 * 修改
	 * @param nur
	 * @return
	 * @throws Exception
	 */
	int user_upda(Topic top)throws Exception;
}
