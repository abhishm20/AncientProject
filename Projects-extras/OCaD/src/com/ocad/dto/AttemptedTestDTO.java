package com.ocad.dto;

public class AttemptedTestDTO {

	private String attemptedTestId;
	private int marksObtained;
	private boolean paas;
	public String getAttemptedTestId() {
		return attemptedTestId;
	}
	public void setAttemptedTestId(String attemptedTestId) {
		this.attemptedTestId = attemptedTestId;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public boolean isPaas() {
		return paas;
	}
	public void setPaas(boolean paas) {
		this.paas = paas;
	}
	
	
}
