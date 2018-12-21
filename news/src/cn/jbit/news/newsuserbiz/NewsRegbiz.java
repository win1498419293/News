package cn.jbit.news.newsuserbiz;

import java.util.List;

import cn.jbit.news.bean.Comment;
import cn.jbit.news.bean.Paging;

public interface NewsRegbiz {
	
	List news_paging(Paging pag) throws Exception;
	int page_max()throws Exception;
	List news_urse_query()throws Exception;
	List  comment_query(Comment comm)throws Exception;
	int addcomm(Comment comm)throws Exception;
}
