package com.Dao;

import com.Pojo.Admin;

public interface AdminDao {
	public Admin getAdminByUsernamePassword(String username, String password);
}
