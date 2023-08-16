package com.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtility.DBConnection;
import com.Dao.TechnicianDao;
import com.Pojo.Technician;

public class TechnicianDaoIMPL implements TechnicianDao
{
	java.sql.Connection con = DBConnection.connection();
	PreparedStatement stmt;
	int row = 0;
	ResultSet rs;
	public boolean AddTechnician(Technician t) 
	{
		try 
		{
			stmt = con.prepareStatement("INSERT INTO Technician(tusername,tpassword,taddress,tcontact, tisAssigned) values(?,?,?,?,?)");
			stmt.setString(1, t.getTusername());
			stmt.setString(2, t.getTpassword());
			stmt.setString(3, t.getTaddress());
			stmt.setString(4, t.getTcontact());
			stmt.setInt(5, t.getTisAssigned());
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

	
	public List<Technician> getTechnicianByUsernamePassword(String tusername, String tpassword) 
	{
		List<Technician> li = new ArrayList<Technician>();
		Technician t;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Technician WHERE tusername=? AND tpassword=?");
			stmt.setString(1, tusername);
			stmt.setString(2, tpassword);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			t = new Technician(rs.getString("tusername"),rs.getString("tpassword"),rs.getString("tcontact"),rs.getString("taddress"),rs.getInt("tisAssigned"));
			t.setTid(rs.getInt("tid"));
			li.add(t);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
	
	public boolean UpdateTechnician(Technician t) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Technician SET tusername=?, tpassword=?, taddress=?, tcontact=?, tisAssigned=? WHERE tid=?");
			stmt.setString(1, t.getTusername());
			stmt.setString(2, t.getTpassword());
			stmt.setString(3, t.getTaddress());
			stmt.setString(4, t.getTcontact());
			stmt.setInt(5, t.getTisAssigned());
			stmt.setInt(6, t.getTid());
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
	
	public boolean UpdateTechnicianById(Technician t) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Technician SET tusername=?, tpassword=?, taddress=?, tcontact=?, tisAssigned=? WHERE tid=?");
			stmt.setString(1, t.getTusername());
			stmt.setString(2, t.getTpassword());
			stmt.setString(3, t.getTaddress());
			stmt.setString(4, t.getTcontact());
			stmt.setInt(5, t.getTisAssigned());
			stmt.setInt(6, t.getTid());
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
	
	public int getisAssigned(int tid) {
		Technician t = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM Technician WHERE tid=?");
			stmt.setInt(1, tid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			t = new Technician(rs.getString("tusername"),rs.getString("tpassword"),rs.getString("tcontact"),rs.getString("taddress"),rs.getInt("tisAssigned"));
			t.setTid(rs.getInt("tid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t.getTisAssigned();
	}
	
	public boolean UpdateTechnicianByUsername(Technician t) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Technician SET tpassword=?, taddress=?, tcontact=? WHERE tusername=?");
			stmt.setString(1, t.getTpassword());
			stmt.setString(2, t.getTaddress());
			stmt.setString(3, t.getTcontact());
			stmt.setString(4, t.getTusername());
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


	public boolean DeleteTechnician(int tid) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Technician WHERE tid=?");
			stmt.setInt(1, tid);
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
	
	public boolean DeleteTechnicianByName(String tusername) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Technician WHERE tusername=?");
			stmt.setString(1, tusername);
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

	
	public List<Technician> getTechnicianById(int tid) 
	{
		List<Technician> li = new ArrayList<Technician>();
		Technician t;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Technician WHERE tid=? ");
			stmt.setInt(1, tid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			t = new Technician(rs.getString("tusername"),rs.getString("tpassword"),rs.getString("taddress"),rs.getString("tcontact"),rs.getInt("tisAssigned"));
			t.setTid(rs.getInt("tid"));
			li.add(t);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}

	public Technician getTechnicianID() 
	{
		List<Technician> li = new ArrayList<Technician>();
		Technician t;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Technician WHERE tisAssigned=? ");
			stmt.setInt(1, 0);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			t = new Technician(rs.getString("tusername"),rs.getString("tpassword"),rs.getString("taddress"),rs.getString("tcontact"),rs.getInt("tisAssigned"));
			t.setTid(rs.getInt("tid"));
			li.add(t);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(li.isEmpty())
			return null; // meaning there is not non assigned technician available
		try {
			stmt = con.prepareStatement("UPDATE Technician SET tisAssigned=? WHERE tid=?");
			stmt.setInt(1, 1);
			stmt.setInt(2, li.get(0).getTid());
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li.get(0);
	}


	@Override
	public List<Technician> getTechnicianByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Technician> getAllTechnicians() 
	{
		List<Technician> li = new ArrayList<Technician>();
		Technician t;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Technician");
			rs = stmt.executeQuery();
			while(rs.next())
			{
			t = new Technician(rs.getString("tusername"),rs.getString("tpassword"),rs.getString("taddress"),rs.getString("tcontact"),rs.getInt("tisAssigned"));
			t.setTid(rs.getInt("tid"));
			li.add(t);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
}

