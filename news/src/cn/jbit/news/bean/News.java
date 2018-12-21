package cn.jbit.news.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class News implements Serializable {
	private Integer nid;
	//选择新闻主题
	private Integer ntid;
	private String ntame;
	//新闻标题
	private String ntitle;
	//作者
	private String nauthor;
	//上传时间
	private Date ncreatedate;
	//上传图片路径
	private String npicpath;
	//新闻内容
	private String ncontent;
	//新闻修改时间
	private Date nmodifydate;
	//摘要
	private String nsummary;
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(Integer nid, Integer ntid, String ntame, List<Comment> comments, String ntitle, String nauthor,
			Date ncreatedate, String npicpath, String ncontent, Date nmodifydate, String nsummary) {
		super();
		this.nid = nid;
		this.ntid = ntid;
		this.ntame = ntame;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.ncreatedate = ncreatedate;
		this.npicpath = npicpath;
		this.ncontent = ncontent;
		this.nmodifydate = nmodifydate;
		this.nsummary = nsummary;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getNtid() {
		return ntid;
	}

	public void setNtid(Integer ntid) {
		this.ntid = ntid;
	}

	public String getNtame() {
		return ntame;
	}

	public void setNtame(String ntame) {
		this.ntame = ntame;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNauthor() {
		return nauthor;
	}

	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}

	public Date getNcreatedate() {
		return ncreatedate;
	}

	public void setNcreatedate(Date ncreatedate) {
		this.ncreatedate = ncreatedate;
	}

	public String getNpicpath() {
		return npicpath;
	}

	public void setNpicpath(String npicpath) {
		this.npicpath = npicpath;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNmodifydate() {
		return nmodifydate;
	}

	public void setNmodifydate(Date nmodifydate) {
		this.nmodifydate = nmodifydate;
	}

	public String getNsummary() {
		return nsummary;
	}

	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
}