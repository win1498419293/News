package cn.jbit.news.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Downlod
 */
@WebServlet("/Downlod")
public class Downlod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-download");
		PrintWriter out=response.getWriter();
		OutputStream fos=null;
		InputStream fis = null;
		try {
			String filename=request.getParameter("filename");
		String path=request.getRealPath("/");
		String filepath=path+"/upload/"+filename;
		response.addHeader("Conten-Disposition", "attachment;filename="+filename);
		fos=response.getOutputStream();
		fis=new FileInputStream(filepath);
		byte[] b=new byte[1024];
		int len=0;
		while ((len=fis.read(b))!=-1) {
			fos.write(b,0,len);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fos.close();
			fis.close();
		}
		out.flush();
		out.close();
	}

}
