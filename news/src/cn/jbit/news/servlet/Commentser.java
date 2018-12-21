package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.jbit.news.bean.Comment;
import cn.jbit.news.bean.News;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserbiz.NewsBiz;
import cn.jbit.news.newsuserbiz.NewsRegbiz;
import cn.jbit.news.newsuserbiz.impl.NewsBizImpl;
import cn.jbit.news.newsuserbiz.impl.NewsRegimpl;
/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Commentser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("txt/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		String comtype=request.getParameter("comtype");
		NewsRegbiz rbiz=new NewsRegimpl();
		NewsBiz biz=new NewsBizImpl();
		if(comtype.equals("query")) {
			Comment comm=new Comment();
			News news=new News();
			news.setNid(Integer.valueOf(request.getParameter("id")));
			try {
				List<News>li=biz.query_news_obj(news);
				for(News com:li) {
					comm.setCnid(com.getNtid());
				}
				List<News>list=rbiz.comment_query(comm);
				if (li.size()!=0&&list.size()!=0) {
					session.setAttribute("newsid", li);
					session.setAttribute("commid", list);
					response.sendRedirect("read_news.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (comtype.equals("addComment")) {
			Comment comm=new Comment();
			News news=new News();
			news.setNid(Integer.valueOf(request.getParameter("nid")));;
			int b1=0;
			comm.setCauth(request.getParameter("uname"));
			comm.setCconent(request.getParameter("utxt"));
			comm.setCip(request.getParameter("cip"));
			comm.setCnid(Integer.valueOf(request.getParameter("nid")));
			try {
				b1=rbiz.addcomm(comm);
				if (b1>0) {
					List<News>list=rbiz.comment_query(comm);
					List<Comment>li=biz.query_news_obj(news);
					session.setAttribute("newsid", li);
					session.setAttribute("commid", list);
					response.sendRedirect("read_news.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
