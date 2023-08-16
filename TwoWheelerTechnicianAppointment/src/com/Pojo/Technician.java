package com.Pojo;

public class Technician 
{
	private int tid;
	private String tusername;
	private String tpassword;
	private String taddress;
	private String tcontact;
	private int tisAssigned;
	
	public Technician(String tusername, String tpassword, String taddress, String tcontact, int tisAssigned) {
		super();
		this.tusername = tusername;
		this.tpassword = tpassword;
		this.taddress = taddress;
		this.tcontact = tcontact;
		this.tisAssigned = tisAssigned;
	}
	
	public int getTisAssigned() {
		return tisAssigned;
	}

	public void setTisAssigned(int tisAssigned) {
		this.tisAssigned = tisAssigned;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTusername() {
		return tusername;
	}

	public void setTusername(String tusername) {
		this.tusername = tusername;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	public String getTcontact() {
		return tcontact;
	}

	public void setTcontact(String tcontact) {
		this.tcontact = tcontact;
	}
	
	@Override
	public String toString() {
		return "Technician [tid=" + tid + ", tusername=" + tusername + ", tpassword=" + tpassword + ", taddress="
				+ taddress + ", tcontact=" + tcontact + ", tisAssigned=" + tisAssigned + "]";
	}
}
