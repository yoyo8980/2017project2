package com.hb.model.index;

import java.sql.Date;

public class IndexDto {
	
	private String lecName;
	private String team;
	private int sid;	
	private int hrid;
	private int lecId;
	private boolean logChk;
	private Date ending;
	private String status;
	private String tname;
	private int tid;
	
	
	public IndexDto() {
	
	}
	public int getLecId() {
		return lecId;
	}
	public void setLecId(int lecId) {
		this.lecId = lecId;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getHrid() {
		return hrid;
	}
	public void setHrid(int hrid) {
		this.hrid = hrid;
	}
	public void setLogChk(boolean logChk) {
		this.logChk = logChk;
	}
	public boolean getLogChk() {
		return logChk;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Date getEnding() {
		return ending;
	}
	public void setEnding(Date ending) {
		this.ending = ending;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	
	
}