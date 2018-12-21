package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserbiz.topicbiz;
import cn.jbit.news.newsuserbiz.impl.topbizimpl;

/**
 * Servlet implementation class doNewslistservlet
 */
@WebServlet("/dolist")
public class doNewslistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  topicbiz top=new topbizimpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("txt/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<Topic>li=null;
		try{
			li=top.news_topic_find();
			if(li!=null){
				session.setAttribute("topic", li);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("newspages/admin.jsp");
	}

}
