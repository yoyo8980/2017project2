package com.hb.model;

public class QnADto {
	private int qnaid;
	private String author;
	private String email;
	private String phonenum;
	private String content;
	
	public QnADto(){}

	public int getQnaid() {
		return qnaid;
	}

	public void setQnaid(int qnaid) {
		this.qnaid = qnaid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
