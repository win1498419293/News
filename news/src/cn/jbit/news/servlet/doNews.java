package cn.jbit.news.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.bean.Paging;
import cn.jbit.news.newsuserbiz.NewsRegbiz;
import cn.jbit.news.newsuserbiz.newsuserbiz;
import cn.jbit.news.newsuserbiz.impl.NewsRegimpl;
import cn.jbit.news.newsuserbiz.impl.newsuserimpl;

@WebServlet(asyncSupported=true,urlPatterns={"/register","/login","/pag","/newUpload"})
public class doNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private newsuserbiz biz=new newsuserimpl();
	private NewsRegbiz rbiz=new NewsRegimpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	response.setContentType("txt/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	request.setCharacterEncoding("utf-8");
	String type = request.getParameter("type");
	String res = null;
	HttpSession session=request.getSession();
	if(type.equals("reg")){
		News_user user = new News_user();
		user.setUserName(request.getParameter("userName"));
		//瀵嗙爜
		user.setPassword(request.getParameter("password"));
		//閭
		user.setEmail(request.getParameter("email"));
		//鐢ㄦ埛绫诲瀷
		user.setUserType(Integer.valueOf(request.getParameter("userType")));
		//鏍囧噯
		int bl = 0;
		try{
			//鐢ㄦ埛娉ㄥ唽
			bl =biz.user_add(user);
			//鍒ゆ柇
			if(bl==1){//鎴愬姛
				res = "index.jsp";
			}
			else{//澶辫触
				res = "newspages/userCreate.jsp";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//閲嶅畾鍚�
		response.sendRedirect(res);
	}
	else if(type.equals("login")){
		int b2= 0;
		//鏂伴椈鐢ㄦ埛瀵硅薄
		News_user user = new News_user();
		
		//鐢ㄦ埛鍚�
		user.setUserName(request.getParameter("uname").trim());
		//瀵嗙爜
		user.setPassword(request.getParameter("upwd").trim());
		//鐧诲綍
		try {
			b2 = biz.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//鍒ゆ柇
		if(b2==1){
			session.setAttribute("user", user.getUserName());
			session.setAttribute("passowrd", user.getPassword());
			res = "dolist";
		}
		else{
			res = "index.jsp";
		}
		response.sendRedirect(res);
	}else if(type.equals("upload")){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096*20);
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean bl = false;
		try{
			List list = upload.parseRequest(request);
			Iterator it = list.iterator();
			while(it.hasNext()){
				FileItem item = (FileItem)it.next();
				if(item.isFormField()){
					String remark1 = item.getFieldName();
					String remark1_value = item.getString("utf-8");
					System.out.println("/t澶囨敞鍊�:"+remark1_value);
				}
				else{
					String path=request.getRealPath("/");
					 char indexChar = '\\';
					 String longFileName = item.getName();
					 String fileName =item.getName().substring(longFileName.lastIndexOf(indexChar) + 1,
								longFileName.length());
					 path = path + "/upload/"+fileName;
					System.out.print(path);
					File file = new File(path);
					item.write(file);
				}
			}
			bl = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(bl){
			out.print("<script>alert('鏂囦欢涓婁紶鎴愬姛');location.href = 'newspages/upload.jsp'</script>");
			
		}
		else{
			out.print("<script>alert('鏂囦欢涓婁紶澶辫触');location.href = 'newspages/upload.jsp'</script>");
		}
	}else if(type.equals("paging")){
		String pindex=request.getParameter("index");
		int index=0;
		if(pindex==null){
			index=1;
		}else{
			index=Integer.valueOf(pindex);
		}
		Paging pag=new Paging();
		pag.setStart(5*(index-1));
		pag.setCou_rec(5);
		List<News_user> list;
		try {
			list = rbiz.news_paging(pag);
			int cun=rbiz.page_max();
			int max=cun%pag.getCou_rec()==0?cun/pag.getCou_rec():cun/pag.getCou_rec()+1;
					if(list.size()>0){
				session.setAttribute("ulist", list);
				session.setAttribute("index", index);
				session.setAttribute("cun", max);
				response.sendRedirect("newspages/users_login.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else  if (type.equals("check")) {
		String name=request.getParameter("name");
		boolean b1=false;
		try {
			List<News_user> li=rbiz.news_urse_query();
			if (li!=null) {
			for(News_user List:li) {
				if (List.getUserName().equals(name)) {
					b1=true;
				}
			}
		}
			out.print(b1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	out.flush();
	out.close();
	}

}
