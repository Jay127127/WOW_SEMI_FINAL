package com.wow.calender.controller;

public class CalVo {
	
	
	private String rouName;
	private int exerNo;
	private int interv;

	public String getRouName() {
		return rouName;
	}
	public void setRouName(String rouName) {
		this.rouName = rouName;
	}
	public int getExerNo() {
		return exerNo;
	}
	public void setExerNo(int exerNo) {
		this.exerNo = exerNo;
	}
	public int getInterv() {
		return interv;
	}
	public void setInterv(int interv) {
		this.interv = interv;
	}
	@Override
	public String toString() {
		return "CalVo [rouName=" + rouName + ", exerNo=" + exerNo + ", interv=" + interv + "]";
	}	
	
}
