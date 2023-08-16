package com.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtility.DBConnection;
import com.Dao.CustomerDao;
import com.Pojo.Customer;

public class CustomerDaoIMPL implements CustomerDao
{
	java.sql.Connection con = DBConnection.connection();
	PreparedStatement stmt;
	int row = 0;
	ResultSet rs;
	public boolean AddCustomer(Customer c) 
	{
		try 
		{
			stmt = con.prepareStatement("INSERT INTO Customer(cusername,cpassword,ccontact,caddress) values(?,?,?,?)");
			stmt.setString(1, c.getCusername());
			stmt.setString(2, c.getCpassword());
			stmt.setString(3, c.getCcontact());
			stmt.setString(4, c.getCaddress());
			row = stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	
	public boolean UpdateCustomer(Customer c) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Customer SET cusername=?, cpassword=?, ccontact=?, caddress=? where cid=?");
			stmt.setString(1, c.getCusername());
			stmt.setString(2, c.getCpassword());
			stmt.setString(3, c.getCcontact());
			stmt.setString(4, c.getCaddress());
			stmt.setInt(5, c.getCid());
			row = stmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}
	
	public boolean UpdateCustomerByUsername(Customer c) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Customer SET cpassword=?, ccontact=?, caddress=? WHERE cusername=?");
			stmt.setString(1, c.getCpassword());
			stmt.setString(2, c.getCcontact());
			stmt.setString(3, c.getCaddress());
			stmt.setString(4, c.getCusername());
			row = stmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}


	public boolean DeleteCustomer(int cid) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Customer WHERE cid=?");
			stmt.setInt(1, cid);
			row = stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}
	
	public boolean DeleteCustomerByUsername(String cusername) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Customer WHERE cusername=?");
			stmt.setString(1, cusername);
			row = stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	
	public List<Customer> getCustomerById(int cid) 
	{
		List<Customer> li = new ArrayList<Customer>();
		Customer c;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Customer WHERE cid=? ");
			stmt.setInt(1, cid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			c = new Customer(rs.getString("cusername"),rs.getString("cpassword"),rs.getString("ccontact"),rs.getString("caddress"));
			c.setCid(rs.getInt("cid"));
			li.add(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}

	
	public List<Customer> getCustomerByUsername(String cusername) 
	{
		List<Customer> li = new ArrayList<Customer>();
		Customer c;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Customer WHERE cusername=?");
			stmt.setString(1, cusername);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			c = new Customer(rs.getString("cusername"),rs.getString("cpassword"),rs.getString("ccontact"),rs.getString("caddress"));
			c.setCid(rs.getInt("cid"));
			li.add(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
	
	public List<Customer> getCustomerByUsernamePassword(String cusername, String cpassword) 
	{
		List<Customer> li = new ArrayList<Customer>();
		Customer c;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Customer WHERE cusername=? AND cpassword=?");
			stmt.setString(1, cusername);
			stmt.setString(2, cpassword);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			c = new Customer(rs.getString("cusername"),rs.getString("cpassword"),rs.getString("ccontact"),rs.getString("caddress"));
			c.setCid(rs.getInt("cid"));
			li.add(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}

	
	public List<Customer> getAllCustomers() 
	{
		List<Customer> li = new ArrayList<Customer>();
		Customer c;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Customer");
			rs = stmt.executeQuery();
			while(rs.next())
			{
			c = new Customer(rs.getString("cusername"),rs.getString("cpassword"),rs.getString("ccontact"),rs.getString("caddress"));
			c.setCid(rs.getInt("cid"));
			li.add(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
}
