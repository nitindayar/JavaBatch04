package com.Dao;

import java.util.List;

import com.Pojo.Customer;

public interface CustomerDao 
{
	public boolean AddCustomer(Customer c);
	public boolean UpdateCustomer(Customer c);
	public boolean DeleteCustomer(int cid);
	public List<Customer> getCustomerById(int cid);
	public List<Customer> getCustomerByUsername(String username);
	public List<Customer> getAllCustomers();
}
