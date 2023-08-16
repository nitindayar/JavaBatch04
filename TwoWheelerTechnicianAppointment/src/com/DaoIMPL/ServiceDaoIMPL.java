package com.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtility.DBConnection;
import com.Dao.ServiceDao;
import com.Pojo.Service;

public class ServiceDaoIMPL implements ServiceDao
{
	java.sql.Connection con = DBConnection.connection();
	PreparedStatement stmt;
	int row = 0;
	ResultSet rs;
	public boolean AddService(Service s) 
	{
		try 
		{
			stmt = con.prepareStatement("INSERT INTO Service(sname,scharge) values(?,?)");
			stmt.setString(1, s.getSname());
			stmt.setString(2, s.getScharge());
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

	
	public boolean UpdateService(Service s) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Service SET sname=?, scharge=? WHERE sid=?");
			stmt.setString(1, s.getSname());
			stmt.setString(2, s.getScharge());
			stmt.setInt(3, s.getSid());
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


	public boolean DeleteService(int sid) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Service WHERE sid=?");
			stmt.setInt(1, sid);
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

	
	public List<Service> getAllService() 
	{
		List<Service> li = new ArrayList<Service>();
		Service s;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Service");
			rs = stmt.executeQuery();
			while(rs.next())
			{
			s = new Service(rs.getString("sname"),rs.getString("scharge"));
			s.setSid(rs.getInt("sid"));
			li.add(s);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public List<Service> getServiceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Service> getServiceByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Service> getAllServices() {
		// TODO Auto-generated method stub
		return null;
	}
}
