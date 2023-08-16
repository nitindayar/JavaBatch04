package com.Test;

import java.util.Scanner;

import com.DaoIMPL.AdminDaoIMPL;
import com.Pojo.Admin;

public class AdminTest 
{
	AdminDaoIMPL ad = new AdminDaoIMPL();
	boolean result;
	Admin obj;
	String username, password;
	Scanner sc = new Scanner(System.in);	
	
	public boolean loginAdmin() {
		System.out.println("Enter username: ");
		username = sc.next();
		System.out.println("Enter password: ");
		password = sc.next();
		obj = ad.getAdminByUsernamePassword(username,password);
		if(obj != null) 
			return true;
		return false;
	}	
}
