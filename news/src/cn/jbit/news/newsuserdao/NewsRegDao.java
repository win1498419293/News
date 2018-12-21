package cn.jbit.news.newsuserdao;

import java.util.List;

public interface NewsRegDao {
	List query_pag(String sql,Object...params) throws Exception;
	int page_max(String sql,Object...params) throws Exception ;
	List query_comment(String sql,Object...params)throws Exception;
	int commadd(String sql,Object...params)throws Exception;
}
