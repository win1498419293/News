package cn.jbit.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jbit.news.bean.News_user;
@WebFilter("/newspages/*")
public class Lock implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rep=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		News_user user = new News_user();
		user.setUserName((String)session.getAttribute("user"));
		user.setPassword((String)session.getAttribute("passowrd"));
		if(user.getUserName()==null || user.getPassword()==null){
			rep.sendRedirect("../index.jsp");
			}else {
				chain.doFilter(request, response);
			}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
