package com.wow.board.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardVo {
	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String userId;
	private Date boardDate;
	private String boardContent;
	private String boardOpen_YN;
	private String boardDelete_YN;
	private int viewCount;
	private int likeCount;
	
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardOpen_YN() {
		return boardOpen_YN;
	}
	public void setBoardOpen_YN(String boardOpen_YN) {
		this.boardOpen_YN = boardOpen_YN;
	}
	public String getBoardDelete_YN() {
		return boardDelete_YN;
	}
	public void setBoardDelete_YN(String boardDelete_YN) {
		this.boardDelete_YN = boardDelete_YN;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
	
}


