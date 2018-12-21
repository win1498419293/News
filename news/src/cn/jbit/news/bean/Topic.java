package cn.jbit.news.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 新闻主题
 * @author Administrator
 *
 */
public class Topic implements Serializable {
	//主题id
  	private Integer tid;
  	//主题名称
    private String tname;
    //主题创建时间
    private Timestamp createDate;
    
    public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Topic(Integer tid, String tname, Timestamp createDate) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.createDate = createDate;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
