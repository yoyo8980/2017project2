package com.hb.model.roll;

import java.sql.Date;

public class RollDto {
	private int rollid;
	private Date calldate;
	private int stuid;
	private String stuname;
	private int sclass;
	private String status;
	public RollDto() {
		
	}
	public int getRollid() {
		return rollid;
	}
	public void setRollid(int rollid) {
		this.rollid = rollid;
	}
	public Date getCalldate() {
		return calldate;
	}
	public void setCalldate(Date calldate) {
		this.calldate = calldate;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		this.sclass = sclass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
