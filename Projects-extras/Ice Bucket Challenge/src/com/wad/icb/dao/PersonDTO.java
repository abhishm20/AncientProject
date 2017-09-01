package com.wad.icb.dao;

public class PersonDTO {

	private int id;
	private String name;
	private double donated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDonated() {
		return donated;
	}
	public void setDonated(double donated) {
		this.donated = donated;
	}
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
