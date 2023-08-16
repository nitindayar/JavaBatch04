package com.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DBUtility.DBConnection;
import com.Dao.AppointmentDao;
import com.Pojo.Appointment;

public class AppointmentDaoIMPL implements AppointmentDao
{
	java.sql.Connection con = DBConnection.connection();
	PreparedStatement stmt;
	int row = 0;
	ResultSet rs;
	public boolean AddAppointment(Appointment a)
	{
		//String customDateTimeString = "2023-08-10 15:30:00";
		try 
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date customDateTime = dateFormat.parse(a.getAdate());
	        Timestamp customTimestamp = new Timestamp(customDateTime.getTime());
			stmt = con.prepareStatement("INSERT INTO Appointment(cid,sid,tid,adate) values(?,?,?,?)");
			stmt.setInt(1, a.getCid());
			stmt.setInt(2, a.getSid());
			stmt.setInt(3, a.getTid());
			stmt.setTimestamp(4, customTimestamp);
			row = stmt.executeUpdate();
		} 
		catch (SQLException | ParseException e) 
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	
	public boolean UpdateAppointmentService(Appointment a) 
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Appointment SET sid=? WHERE aid=?");
			stmt.setInt(1, a.getSid());
			stmt.setInt(2, a.getAid());
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
	
	public boolean UpdateAppointmentDate(Appointment a)
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Appointment SET adate=? WHERE aid=?");
			stmt.setString(1, a.getAdate());
			stmt.setInt(2, a.getAid());
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
	
	public boolean UpdateAppointmentTechnician(Appointment a)
	{
		try 
		{
			stmt = con.prepareStatement("UPDATE Appointment SET tid=? WHERE aid=?");
			stmt.setInt(1, a.getTid());
			stmt.setInt(2, a.getAid());
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


	public boolean DeleteAppointment(int aid) 
	{
		try 
		{
			stmt = con.prepareStatement("DELETE FROM Appointment WHERE aid=?");
			stmt.setInt(1, aid);
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
	
	public List<Appointment> getAllAppointments() 
	{
		List<Appointment> li = new ArrayList<Appointment>();
		Appointment a;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Appointment");
			rs = stmt.executeQuery();
			while(rs.next())
			{
			a = new Appointment(rs.getInt("cid"),rs.getInt("sid"),rs.getInt("tid"),rs.getString("adate"));
			a.setAid(rs.getInt("aid"));
			li.add(a);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public boolean UpdateAppointment(Appointment a) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Appointment> getAppointmentById(int aid) 
	{
		List<Appointment> li = new ArrayList<Appointment>();
		Appointment a;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Appointment WHERE aid=? ");
			stmt.setInt(1, aid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			a = new Appointment(rs.getInt("cid"),rs.getInt("sid"),rs.getInt("tid"),rs.getString("adate"));
			a.setAid(rs.getInt("aid"));
			li.add(a);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
	
	public List<Appointment> getAppointmentByTechnicianId(int tid) 
	{
		List<Appointment> li = new ArrayList<Appointment>();
		Appointment a;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Appointment WHERE tid=? ");
			stmt.setInt(1, tid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			a = new Appointment(rs.getInt("cid"),rs.getInt("sid"),rs.getInt("tid"),rs.getString("adate"));
			a.setAid(rs.getInt("aid"));
			li.add(a);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}

	public List<Appointment> getAppointmentByCustomerID(int cid) 
	{
		List<Appointment> li = new ArrayList<Appointment>();
		Appointment a;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Appointment WHERE cid=?");
			stmt.setInt(1, cid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			a = new Appointment(rs.getInt("cid"),rs.getInt("sid"),rs.getInt("tid"),rs.getString("adate"));
			a.setAid(rs.getInt("aid"));
			li.add(a);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Appointment> getAppointmentByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
