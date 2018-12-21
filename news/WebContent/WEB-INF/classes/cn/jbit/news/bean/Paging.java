package cn.jbit.news.bean;

import java.io.Serializable;

/**
 * 分页实体
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Paging implements Serializable {
	
	//分页id
	private Integer pid;
	//分页起点
	private Integer start;
	//每页总记录
	private Integer cou_rec;
	
	public Paging() {
		// TODO Auto-generated constructor stub
	}

	public Paging(Integer pid, Integer start, Integer cou_rec) {
		super();
		this.pid = pid;
		this.start = start;
		this.cou_rec = cou_rec;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCou_rec() {
		return cou_rec;
	}

	public void setCou_rec(Integer cou_rec) {
		this.cou_rec = cou_rec;
	}
}
