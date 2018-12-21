package cn.jbit.news.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.jbit.news.bean.News;
import cn.jbit.news.newsuserbiz.NewsBiz;
import cn.jbit.news.newsuserbiz.impl.NewsBizImpl;

/**
 * Servlet implementation class newsServlte
 */
@WebServlet("/newsServlte")
public class newsServlte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsBiz biz  = new NewsBizImpl();
	News news =new News();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);
		ServletFileUpload upload=new ServletFileUpload(factory);
		HttpSession session=request.getSession();
		int b1=0;
		String do_news=request.getParameter("data");
		if(do_news.equals("add")){
			News news;
			try {
				news = this.file_upload(request);
				b1=biz.news_add(news);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b1==1){
				out.print("<script type='text/javascript' >alert('添加成功!');location.href='newspages/news_read.jsp';</script>");
			}else{
				out.print("<script>alert('添加失败!');location.href='newspages/news_add.jsp';</script>");
				
			}
		}else if(do_news.equals("link")){
			News news=new News();
			news.setNid(Integer.valueOf(request.getParameter("nid")));
			List<News> li;
			try {
				li = biz.query_news_obj(news);
				if(li.size()>0){
					session.setAttribute("unews", li);
					response.sendRedirect("newspages/news_update.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(do_news.equals("update")){
			News news;
			try {
				news = this.file_upload(request);
				b1=biz.news_update(news);  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(b1==1){
				out.print("<script>alert('新闻更新成功!');location.href ='newspages/news_read.jsp';</script>");
				
		}
		else{
			 	out.print("<script>alert('新闻更新失败!');location.href ='newspages/news_update.jsp';</script>");
			}
		}else if(do_news.equals("query")){
			try {
				List<News>	list = biz.query_news(null);
				if(list.size()>0){
					session.setAttribute("nnews", list);
					response.sendRedirect("index.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.flush();
			out.close();
		}
	}
	 public News file_upload(HttpServletRequest request)throws Exception{
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setSizeThreshold(1024*10);
			ServletFileUpload upload=new ServletFileUpload(factory);
			News news =new News();
			try{
				List li=upload.parseRequest(request);
				Iterator it=li.iterator();
				while(it.hasNext()){
					FileItem item=(FileItem)it.next();
					String newItem=item.getFieldName();
					if(item.isFormField()){
						if(newItem.equals("nid")){
							news.setNid(Integer.valueOf(item.getString()));
						}
						//主题
						if(newItem.equals("ntid")){
							news.setNtid(Integer.valueOf(item.getString("utf-8")));
						}
						//标题
						if(newItem.equals("ntitle")){
							news.setNtitle(item.getString("utf-8"));
						}
						//作者
						if(newItem.equals("nauthor")){
							news.setNauthor(item.getString("utf-8"));
						}
						//摘要
						if(newItem.equals("nsummary")){
							news.setNsummary(item.getString("utf-8"));
						}
						//内容
						if(newItem.equals("ncontent")){
							news.setNcontent(item.getString("utf-8"));
						}
					}else{
						String path=request.getRealPath("/");
						
						Random ran = new Random();
						 char indexChar = '\\';
						int dom = ran.nextInt(50500);
						 String longFileName = item.getName();
						 String fileName = dom+item.getName().substring(longFileName.lastIndexOf(indexChar) + 1,
									longFileName.length());
						path=path+"images/upload/"+fileName;
						String newPath=path.replace("/","\\");
						if(newItem.equals("npicpath")){
							news.setNpicpath(newPath);
						}
						System.out.println(newPath);
						File file=new File(newPath);
						if (file.exists()) {
							file.mkdirs();
						}
						item.write(file);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return  news;
			}

}
