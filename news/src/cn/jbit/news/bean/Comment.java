package cn.jbit.news.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 *
 */
public class Comment implements Serializable {
    //评论id
	private int cid;
    //评论的新闻id
	private Integer cnid;
    //留言内容
	private String cconent;
    //留言时间
	private Date cdate;
    //ip
	private String cip;
    //留言人
	private String cauth;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int cid, Integer cnid, String cconent, Date cdate, String cip, String cauth) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cconent = cconent;
		this.cdate = cdate;
		this.cip = cip;
		this.cauth = cauth;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Integer getCnid() {
		return cnid;
	}

	public void setCnid(Integer cnid) {
		this.cnid = cnid;
	}

	public String getCconent() {
		return cconent;
	}

	public void setCconent(String cconent) {
		this.cconent = cconent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCauth() {
		return cauth;
	}

	public void setCauth(String cauth) {
		this.cauth = cauth;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", cnid=" + cnid + ", cconent=" + cconent + ", cdate=" + cdate + ", cip=" + cip
				+ ", cauth=" + cauth + "]";
	}
}
