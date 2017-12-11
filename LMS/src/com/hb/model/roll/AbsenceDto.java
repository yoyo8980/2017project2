package com.hb.model.roll;

public class AbsenceDto {

	private int stuid;
	private String stuname;
	private int totalAbsence;
	private int totalLate;

	public AbsenceDto(){}

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

	public int getTotalAbsence() {
		return totalAbsence;
	}

	public void setTotalAbsence(int totalAbsence) {
		this.totalAbsence = totalAbsence;
	}

	public int getTotalLate() {
		return totalLate;
	}

	public void setTotalLate(int totalLate) {
		this.totalLate = totalLate;
	}
	
	
	
}
