package com.Dao;

import java.util.List;

import com.Pojo.Service;

public interface ServiceDao {
	public boolean AddService(Service c);
	public boolean UpdateService(Service c);
	public boolean DeleteService(int id);
	public List<Service> getServiceById(int id);
	public List<Service> getServiceByUsername(String username);
	public List<Service> getAllServices();
}
