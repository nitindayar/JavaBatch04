package com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.DaoIMPL.AppointmentDaoIMPL;
import com.DaoIMPL.TechnicianDaoIMPL;
import com.Pojo.Appointment;
import com.Pojo.Technician;

public class TechnicianTest 
{
	TechnicianDaoIMPL td = new TechnicianDaoIMPL();
	AppointmentDaoIMPL ad = new AppointmentDaoIMPL();
	boolean result;
	List<Technician> li = new ArrayList<Technician>();
	@SuppressWarnings("rawtypes")
	Iterator it;
	Technician tt;
	Technician obj;
	int tid;
	String tusername, tpassword, taddress, tcontact;
	Scanner sc = new Scanner(System.in);
	
	public void addTechnician() {
		System.out.println("Enter technician username: ");
		tusername = sc.next();
		System.out.println("Enter technician password: ");
		tpassword = sc.next();
		System.out.println("Enter technician address: ");
		taddress = sc.next();
		System.out.println("Enter technician contact: ");
		tcontact = sc.next();
		result = td.AddTechnician(new Technician(tusername,tpassword,taddress,tcontact,0));
		if(result)
				System.out.println("Technician Added successfully. ");
			else
				System.out.println("Technician Not Added successfully. ");
	}	
				
	public boolean loginTechnician() {
		System.out.println("Enter your name: ");
		tusername = sc.next();
		System.out.println("Enter your password: ");
		tpassword = sc.next();
		li = td.getTechnicianByUsernamePassword(tusername,tpassword);
		if(!li.isEmpty()) {
			// for session tracking
			tt = li.get(0);
			return true;
		}
		return false;
	}
	
	public void updateTechnician() {
		System.out.println("Enter new technician username: ");
		tusername = sc.next();
		System.out.println("Enter new technician password: ");
		tpassword = sc.next();
		System.out.println("Enter new technician address: ");
		taddress = sc.next();
		System.out.println("Enter new technician contact: ");
		tcontact = sc.next();
		Technician t = new Technician(tusername,tpassword,taddress,tcontact,tt.getTisAssigned());
		t.setTid(tt.getTid());
		result = td.UpdateTechnician(t);
		if(result)
			System.out.println("Technician Updated Successfully. ");
		else
			System.out.println("Technician Not Updated Successfully. ");
	}
	
	public void updateTechnicianById() {
		System.out.println("Enter technician id you want to update: ");
		tid = sc.nextInt();
		System.out.println("Enter new technician username: ");
		tusername = sc.next();
		System.out.println("Enter new technician password: ");
		tpassword = sc.next();
		System.out.println("Enter new technician address: ");
		taddress = sc.next();
		System.out.println("Enter new technician contact: ");
		tcontact = sc.next();
		Technician t = new Technician(tusername,tpassword,taddress,tcontact,td.getisAssigned(tid));
		t.setTid(tid);
		result = td.UpdateTechnicianById(t);
		if(result)
			System.out.println("Technician Updated Successfully. ");
		else
			System.out.println("Technician Not Updated Successfully. ");
	}
	
	public void deleteTechnician()
	{
		System.out.println("Enter technician id you want to delete: ");
		tid = sc.nextInt();
		result = td.DeleteTechnician(tid);
		if(result)
			System.out.println("Technician Deleted Successfully. ");
		else
			System.out.println("Technician Not Deleted Successfully. ");
	}
				
	public void getTechnicianById()
	{
		li = td.getTechnicianById(tt.getTid());
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
						
	public void getAppointmentByTechnicianId()
	{
		List<Appointment> list = new ArrayList<Appointment>();
		list = ad.getAppointmentByTechnicianId(tt.getTid());
		it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
	
	public void showAllTechnicians()
	{
		li = td.getAllTechnicians();
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
}
