package com.Pojo;

public class Service 
{
	private int sid;
	private String sname;
	private String scharge;
	public Service(String sname, String scharge) {
		super();
		this.sname = sname;
		this.scharge = scharge;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScharge() {
		return scharge;
	}
	public void setScharge(String scharge) {
		this.scharge = scharge;
	}
	@Override
	public String toString() {
		return "Service [sid=" + sid + ", sname=" + sname + ", scharge=" + scharge + "]";
	}
}
