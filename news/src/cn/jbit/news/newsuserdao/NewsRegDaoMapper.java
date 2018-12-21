package cn.jbit.news.newsuserdao;

import java.util.List;

public interface NewsRegDaoMapper {
	List query_pag() throws Exception;
	int page_max() throws Exception ;
	List query_comment()throws Exception;
	int commadd()throws Exception;
}
