package com.lib.dto;

public class BookInfoDTO {
	private String book_id;
	private String book_name;
	private Double fine;
	private String issue_date;
	@Override
	public String toString() {
		return "BookInfoDTO [book_id=" + book_id + ", book_name=" + book_name
				+ ", fine=" + fine + ", issue_date=" + issue_date + "]";
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
}
