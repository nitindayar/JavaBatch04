package com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.DaoIMPL.CustomerDaoIMPL;
import com.Pojo.Customer;

public class CustomerTest 
{
	CustomerDaoIMPL cd = new CustomerDaoIMPL();
	boolean result;
	List<Customer> li = new ArrayList<Customer>();
	@SuppressWarnings("rawtypes")
	Iterator it;
	int cid;
	Customer obj;
	String cusername, cpassword, ccontact, caddress;
	Scanner sc = new Scanner(System.in);
	
	public void registerCustomer() {
		System.out.println("Enter your username: ");
		cusername = sc.next();
		System.out.println("Enter your password: ");
		cpassword = sc.next();
		System.out.println("Enter your contact: ");
		ccontact = sc.next();
		System.out.println("Enter your address: ");
		caddress = sc.next();
		result = cd.AddCustomer(new Customer(cusername,cpassword,ccontact,caddress));
		if(result)
				System.out.println("Registration Done successfully. ");
			else
				System.out.println("Registration Not Done successfully. ");
	}	
	
	public boolean loginCustomer() {
		System.out.println("Enter your cusername ");
		cusername = sc.next();
		System.out.println("Enter your cpassword ");
		cpassword = sc.next();
		li = cd.getCustomerByUsernamePassword(cusername,cpassword);
		if(!li.isEmpty()) {
			// for session tracking
			obj = li.get(0);
			return true;
		}
		return false;
	}
				
	public void updateCustomer() {
		System.out.println("Enter Customer id you want to update: ");
		cid = sc.nextInt();
		System.out.println("Enter new username: ");
		cusername = sc.next();
		System.out.println("Enter new password: ");
		cpassword = sc.next();
		System.out.println("Enter new contact: ");
		ccontact = sc.next();
		System.out.println("Enter new address: ");
		caddress = sc.next();
		Customer c = new Customer(cusername,cpassword,ccontact,caddress);
		c.setCid(cid);
		result = cd.UpdateCustomer(c);
		if(result)
			System.out.println("Customer Updated Successfully. ");
		else
			System.out.println("Customer Not Updated Successfully. ");
	}
	
	public void updateCustomerByUsername() {
		System.out.println("Enter new password: ");
		cpassword = sc.next();
		System.out.println("Enter new contact: ");
		ccontact = sc.next();
		System.out.println("Enter new address: ");
		caddress = sc.next();
		Customer c = new Customer(cusername,cpassword,ccontact,caddress);
		c.setCid(cid);
		result = cd.UpdateCustomerByUsername(c);
		if(result)
			System.out.println("Customer Updated Successfully. ");
		else
			System.out.println("Customer Not Updated Successfully. ");
	}
			
	public void deleteCustomer()
	{
		System.out.println("Enter customer id you want to delete: ");
		cid = sc.nextInt();
		result = cd.DeleteCustomer(cid);
		if(result)
			System.out.println("Customer Deleted Successfully. ");
		else
			System.out.println("Customer Not Deleted Successfully. ");
	}
	
	public void deleteCustomerByUsername()
	{
		result = cd.DeleteCustomerByUsername(cusername);
		if(result)
			System.out.println("Customer Deleted Successfully. ");
		else
			System.out.println("Customer Not Deleted Successfully. ");
	}
				
	public void getCustomerById()
	{
		System.out.println("Enter customer id: ");
		cid = sc.nextInt();
		li = cd.getCustomerById(cid);
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
	
	public Customer getCustomerLoginObject() {
		return obj;
	}
	
	public void getCustomerByUsername()
	{
		li = cd.getCustomerByUsername(cusername);
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
				
	public void updateCustomerU(String cusername)
	{
		System.out.println("Enter customer username: ");
		cusername = sc.next();
		li = cd.getCustomerByUsername(cusername);
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
							
	public void showAllCustomers()
	{
		li = cd.getAllCustomers();
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
}
