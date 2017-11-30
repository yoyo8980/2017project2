package com.hb.model.index;

public class IndexDto {
	
	private String lecName;
	private String team;
	private int sid;	
	private int hrid;
	private int lecId;
	private boolean logChk;
	
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
	
	
	
}