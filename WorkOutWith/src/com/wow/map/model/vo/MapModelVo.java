package com.wow.map.model.vo;

import java.sql.Timestamp;

public class MapModelVo {
	
	private int borardNo;
	private String title;
	private String name;
	private String content;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	
	public int getBorardNo() {
		return borardNo;
	}
	public void setBorardNo(int borardNo) {
		this.borardNo = borardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
	
	
	
}
