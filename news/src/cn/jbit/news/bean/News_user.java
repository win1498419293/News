package cn.jbit.news.bean;

import java.io.Serializable;

/**
 * 用户实体
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class News_user implements Serializable {
	//用户id
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String password;
	//邮箱
	private String email;
	//用户类型
	private Integer userType;
	
	public News_user() {
		// TODO Auto-generated constructor stub
	}

	public News_user(Integer id, String userName, String password, String email, Integer userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "News_user [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", userType=" + userType + "]";
	}
}
