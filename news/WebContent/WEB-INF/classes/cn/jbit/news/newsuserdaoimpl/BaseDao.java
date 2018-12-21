package cn.jbit.news.newsuserdaoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jbit.news.bean.News_user;
import cn.jbit.news.newsuserdao.newsuserdao;
import cn.jbit.news.util.ConfigManager;

public class BaseDao   {
	protected  Connection con;
	//预编译命令
	protected PreparedStatement pstmt;
	//结果集
	protected   ResultSet set;
	public Connection getCon() throws Exception {
		//驱动
		String driver = ConfigManager.getinstacen().getString("driver");
		//url
		String url = ConfigManager.getinstacen().getString("url");
		//用户名
		String user = ConfigManager.getinstacen().getString("user");
		//密码
		String password = ConfigManager.getinstacen().getString("password");
		
		try {
			//加载驱动
			Class.forName("\""+driver+"\"");
			System.out.println("驱动加载成功");
			//连接
			con= DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public PreparedStatement exec(String sql,Object...patmt)throws Exception {
		try {
			con=this.getCon();
			pstmt=con.prepareStatement(sql);
			if(patmt!=null) {
			for(int i=0;i<patmt.length;i++) {
				pstmt.setObject(i+1, patmt[i]);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	public ResultSet query(String sql,Object...patmt) 
			throws Exception{
		try {
			//产生命令
			pstmt = this.exec(sql,patmt);
			//结果集
			set = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回
		return set;
	}
	public  void destory() throws Exception {
		try {
			if(set!=null) {
				set.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
