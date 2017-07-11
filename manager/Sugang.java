package kdata.manager;

import java.sql.Date;

public class Sugang {

	private String snum;
	private String subcode;
	private String subname;
	private int grade;
	private Date date;
	private String sname;

	public Sugang(String snum, String subcode, int grade, Date date) {

		this.snum = snum;
		this.subcode = subcode;
		this.grade = grade;
		this.date = date;
	}
	
	public Sugang(String snum, String sname, String subname) {

		this.snum = snum;
		this.sname = sname;
		this.subname = subname;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sugang [snum=" + snum + ", subcode=" + subcode + ", grade=" + grade + "]";
	}
	
	
	
}

