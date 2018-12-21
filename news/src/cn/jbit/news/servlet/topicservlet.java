package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.bean.News;
import cn.jbit.news.bean.Topic;
import cn.jbit.news.newsuserbiz.NewsBiz;
import cn.jbit.news.newsuserbiz.topicbiz;
import cn.jbit.news.newsuserbiz.impl.NewsBizImpl;
import cn.jbit.news.newsuserbiz.impl.topbizimpl;

/**
 * Servlet implementation class topicservlet
 */
@WebServlet("/topic")
public class topicservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private topicbiz topic=new topbizimpl();
	private NewsBiz biz=new NewsBizImpl();
	/**
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("txt/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
    String toptype=request.getParameter("toptype");
     PrintWriter out=response.getWriter();
    System.out.print(toptype);
	int b1=0;
	try{
		if(toptype.equals("add")){
			Topic top=new Topic();
			top.setTname(request.getParameter("tname").trim());
			b1=topic.topic_add(top);
			if(b1==1){
				response.sendRedirect("dolist");
			}else{
				out.print("<script>alert('主题添加失败,请重新输入!');open('newspages/topic_add.jsp','_self');</script>");
			}
		}else if(toptype.equals("update")){
			Topic top=new Topic();
			top.setTid(Integer.valueOf(request.getParameter("tid")));
			top.setTname(request.getParameter("tname").trim());
			b1=topic.topic_update(top);
			if(b1==1){
				response.sendRedirect("dolist");
				}else{
					out.print("<script>alert('主题修改失败,请重新输入!');location.href='newspages/topic_modify.jsp';</script>");
				}
		}else if(toptype.equals("delete")){
			Topic top=new Topic();
			top.setTid(Integer.valueOf(request.getParameter("tid")));
			List<News> li=biz.query_news(top);
			if(li.size()>0){
				out.print("<script>alert('该主题下有新闻,不能删除!');location.href='doNews';</script>");
			}else{
				b1=topic.topic_delete(top);
				String res=null;
				if(b1==1){
					res="dolist";
				}else{
					res ="dolist";
				}
				response.sendRedirect(res);
			}
		}else if(toptype.equals("check")){
			String name=request.getParameter("name");
			boolean bb=false;
			try {
				List<Topic>top=biz.news_topic_find();
				if (top!=null) {
					for(Topic li:top) 
				{
						if (li.getTname().equals(name)) {
							bb=true;
						}
				}
				}
				out.print(bb);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	

}
