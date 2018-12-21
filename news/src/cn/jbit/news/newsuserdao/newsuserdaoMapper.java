package cn.jbit.news.newsuserdao;

import java.util.List;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;

public interface newsuserdaoMapper {
	int seve( News_user user) throws Exception;
	List login(News_user user) throws Exception;
	int delete(Topic top)throws Exception;
	int update(Topic top)throws Exception;
}
