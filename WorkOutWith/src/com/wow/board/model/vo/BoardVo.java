package com.wow.board.model.vo;

import java.sql.Timestamp;

public class BoardVo {
	private String title;
	private String category_select;
	private String upload_file;
	private String boardAvailable;
	private String text_area;
	private int boardNo;
	private String userId;
	private Timestamp boardDate;
	
	
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardAvailable() {
		return boardAvailable;
	}
	public void setBoardAvailable(String boardAvailable) {
		this.boardAvailable = boardAvailable;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory_select() {
		return category_select;
	}
	public void setCategory_select(String category_select) {
		this.category_select = category_select;
	}
	public String getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(String upload_file) {
		this.upload_file = upload_file;
	}
	public String getText_area() {
		return text_area;
	}
	public void setText_area(String text_area) {
		this.text_area = text_area;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
	
}


