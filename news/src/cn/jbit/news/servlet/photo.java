package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class photo
 */
@WebServlet("/photo")
public class photo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String ye=request.getParameter("pid");
		String [] path= {
				"../images/photo1.jpg",
				"../images/photo2.jpg",
				"../images/photo3.jpg",
				"../images/photo4.jpg",
				"../images/photo5.jpg"
		};
		out.print(path[Integer.valueOf(ye)]);
	}

}
