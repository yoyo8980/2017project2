package com.hb.model.candi;

public class CandiDto {

	private int sId;
	private String sName;
	private String birth;
	private String phone;
	private String email;
	private String status;
	private int regclass;
	
	public CandiDto() {
		// TODO Auto-generated constructor stub
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRegclass() {
		return regclass;
	}

	public void setRegclass(int regclass) {
		this.regclass = regclass;
	}
	
}
