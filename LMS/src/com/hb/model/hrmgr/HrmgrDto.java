package com.hb.model.hrmgr;

public class HrmgrDto {
	private int hrid;
	private String hrname;
	private String team;
	private String webid;
	
	
	public HrmgrDto() {
		
	}
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	public int getHrid() {
		return hrid;
	}
	public void setHrid(int hrid) {
		this.hrid = hrid;
	}
	public String getHrname() {
		return hrname;
	}
	public void setHrname(String hrname) {
		this.hrname = hrname;
	}
	public String getWebid() {
		return webid;
	}
	public void setWebid(String webid) {
		this.webid = webid;
	}	
	
	
}