package com.DaoIMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBUtility.DBConnection;
import com.Dao.AdminDao;
import com.Pojo.Admin;

public class AdminDaoIMPL implements AdminDao {

	java.sql.Connection con = DBConnection.connection();
	PreparedStatement stmt;
	int row = 0;
	ResultSet rs;
	
	public Admin getAdminByUsernamePassword(String username, String password) {
		Admin a = null;
		try 
		{
			stmt = con.prepareStatement("SELECT * FROM Admin WHERE username=? AND password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next()) {
				a = new Admin(rs.getString("username"),rs.getString("password"));
				a.setId(rs.getInt("id"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return a;
	}
}
