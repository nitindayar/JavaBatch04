package com.Dao;

import java.util.List;

import com.Pojo.Technician;

public interface TechnicianDao {
	public boolean AddTechnician(Technician t);
	public boolean UpdateTechnician(Technician t);
	public boolean DeleteTechnician(int tid);
	public List<Technician> getTechnicianById(int tid);
	public List<Technician> getTechnicianByUsername(String username);
	public List<Technician> getAllTechnicians();
}
