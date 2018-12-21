package cn.jbit.news.newsuserdao;
import java.util.List;
import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Topic;
public interface newsuserdao {
	int seve(String sql,News_user nnr) throws Exception;
	List login(String sql,Object...patmt) throws Exception;
	int delete(String sql,Object...patmt)throws Exception;
	int update(String sql,Object...patmt)throws Exception;
}
