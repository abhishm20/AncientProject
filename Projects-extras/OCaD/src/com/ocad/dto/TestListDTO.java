package com.ocad.dto;

public class TestListDTO {
	
	
	private String testId;
	private String subject;
	private int time;
	private int mm;
	private int noOfQue;
	private int level;
	private String testUrl;
	
	
	public String getTestUrl() {
		return testUrl;
	}
	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getNoOfQue() {
		return noOfQue;
	}
	public void setNoOfQue(int noOfQue) {
		this.noOfQue = noOfQue;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "TestListDTO [testId=" + testId + ", subject=" + subject
				+ ", time=" + time + ", mm=" + mm + ", noOfQue=" + noOfQue
				+ ", level=" + level + "]";
	}
	
}
