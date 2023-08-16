package com.Pojo;

public class Appointment 
{
	private int aid;
	private int cid;
	private int sid;
	private int tid;
	private String adate;
	public Appointment(int cid, int sid, int tid, String adate) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.tid = tid;
		this.adate = adate;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", cid=" + cid + ", sid=" + sid + ", tid=" + tid + ", adate=" + adate + "]";
	}
}
