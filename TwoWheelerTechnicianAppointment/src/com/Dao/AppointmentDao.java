package com.Dao;

import java.util.List;

import com.Pojo.Appointment;

public interface AppointmentDao {
	public boolean AddAppointment(Appointment a);
	public boolean UpdateAppointment(Appointment a);
	public boolean DeleteAppointment(int aid);
	public List<Appointment> getAppointmentById(int aid);
	public List<Appointment> getAppointmentByUsername(String username);
	public List<Appointment> getAllAppointments();
}
