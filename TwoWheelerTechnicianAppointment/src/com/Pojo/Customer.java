package com.Pojo;

public class Customer 
{
	private int cid;
	private String cusername;
	private String cpassword;
	private String ccontact;
	private String caddress;
	public Customer(String cusername, String cpassword, String ccontact, String caddress) {
		super();
		this.cusername = cusername;
		this.cpassword = cpassword;
		this.ccontact = ccontact;
		this.caddress = caddress;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCcontact() {
		return ccontact;
	}
	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cusername=" + cusername + ", cpassword=" + cpassword + ", ccontact="
				+ ccontact + ", caddress=" + caddress + "]";
	}
}
