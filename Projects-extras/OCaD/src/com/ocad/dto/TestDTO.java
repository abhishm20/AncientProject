package com.ocad.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDTO {

	private String testId;
	private String queId;
	private int mm;
	private int time;
	private boolean attempted;
	private boolean pass;
	private int queNo;
	
	public int getQueNo() {
		return queNo;
	}
	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isAttempted() {
		return attempted;
	}
	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "TestDTO [testId=" + testId + ", queId="
				+ queId + ", mm="
				+ mm + ", time=" + time + ", attempted=" + attempted
				+ ", pass=" + pass + "]";
	}
	
	
	
}
