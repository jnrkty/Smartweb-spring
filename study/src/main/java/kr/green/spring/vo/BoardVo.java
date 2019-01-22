package kr.green.spring.vo;

import java.sql.Date;

public class BoardVo {
	private Integer id;
	private String title;
	private String content;
	private String writer;
	private Date registered_date;
	private String state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "BoardVo [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", registered_date=" + registered_date + ", state=" + state + "]";
	}
	

}
