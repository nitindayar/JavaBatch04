package com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.DaoIMPL.AppointmentDaoIMPL;
import com.DaoIMPL.TechnicianDaoIMPL;
import com.Pojo.Appointment;
import com.Pojo.Customer;
import com.Pojo.Technician;

public class AppointmentTest 
{
	AppointmentDaoIMPL ad = new AppointmentDaoIMPL();
	boolean result;
	List<Appointment> li = new ArrayList<Appointment>();
	TechnicianDaoIMPL td = new TechnicianDaoIMPL();
	@SuppressWarnings("rawtypes")
	Iterator it;
	int aid, cid, sid, tid;
	String adate;
	Scanner sc = new Scanner(System.in);
	
	public void makeAppointment(Customer obj) {
		cid = obj.getCid();
		System.out.println("Enter service id: ");
		sid = sc.nextInt();sc.nextLine();
		System.out.println("Enter date and time: ");
		adate = sc.nextLine();
		Technician t = td.getTechnicianID();
		if(t == null) {
			System.out.println("Sorry, Appointment Failed, Technician not available!!!");
			return;
		}
		tid = t.getTid(); //returning non assigned technician
		result = ad.AddAppointment(new Appointment(obj.getCid(),sid,tid,adate));
		if(result)
				System.out.println("Appointment Done successfully. ");
			else
				System.out.println("Appointment Not Done successfully. ");
	}	
	
	public void deleteAppointment() 
	{
		li = ad.getAllAppointments();
		if(li.isEmpty()) {
			System.out.println("You don't have any appointments!");
			return;
		}
		System.out.println("Enter appointment id you want to delete: ");
		aid = sc.nextInt();
		result = ad.DeleteAppointment(aid);
		if(result)
			System.out.println("Appointment Deleted Successfully. ");
		else
			System.out.println("Appointment Not Deleted Successfully. ");
	}

	
	public void getAppointmentByCustomerID(Customer obj)
	{
		li = ad.getAppointmentByCustomerID(obj.getCid());
		if(li.isEmpty()) {
			System.out.println("You don't have any appointments!");
			return;
		}
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
				
	public void updateAppointmentService(Customer obj)
	{
		if(ad.getAppointmentByCustomerID(cid).isEmpty())
			return;
		System.out.println("Enter appointment ID you want to update: ");
		aid = sc.nextInt();
		Appointment a1 = ad.getAppointmentById(aid).get(0);
		System.out.println("Enter new service id for appointment id "+aid+" : ");
		sid = sc.nextInt();
		Appointment a = new Appointment(obj.getCid(),sid,a1.getTid(),a1.getAdate());
		a.setAid(aid);
		result = ad.UpdateAppointmentService(a);
		if(result)
			System.out.println("Appointment Updated Successfully. ");
		else
			System.out.println("Appointment Not Updated Successfully. ");
	}
	
	public void updateAppointmentDate(Customer obj)
	{
		if(ad.getAppointmentByCustomerID(cid).isEmpty())
			return;
		System.out.println("Enter appointment ID you want to update: ");
		aid = sc.nextInt();sc.nextLine();
		Appointment a1 = ad.getAppointmentById(aid).get(0);
		System.out.println("Enter new date and time for appointment id "+aid+" : ");
		String newdate = sc.nextLine();
		Appointment a = new Appointment(a1.getCid(),a1.getSid(),a1.getTid(),newdate);
		a.setAid(aid);
		result = ad.UpdateAppointmentDate(a);
		if(result)
			System.out.println("Appointment Updated Successfully. ");
		else
			System.out.println("Appointment Not Updated Successfully. ");
	}
	
	public void updateAppointmentService()
	{
		if(ad.getAllAppointments().isEmpty())
			return;
		System.out.println("Enter appointment ID you want to update: ");
		aid = sc.nextInt();
		Appointment a1 = ad.getAppointmentById(aid).get(0);
		System.out.println("Enter new service id for appointment id "+aid+" : ");
		sid = sc.nextInt();
		Appointment a = new Appointment(a1.getCid(),sid,a1.getTid(),a1.getAdate());
		a.setAid(aid);
		result = ad.UpdateAppointmentService(a);
		if(result)
			System.out.println("Appointment Updated Successfully. ");
		else
			System.out.println("Appointment Not Updated Successfully. ");
	}
	
	public void updateAppointmentDate()
	{
		if(ad.getAllAppointments().isEmpty())
			return;
		System.out.println("Enter appointment ID you want to update: ");
		aid = sc.nextInt();sc.nextLine();
		Appointment a1 = ad.getAppointmentById(aid).get(0);
		System.out.println("Enter new date and time for appointment id "+aid+" : ");
		String newdate = sc.nextLine();
		Appointment a = new Appointment(a1.getCid(),a1.getSid(),a1.getTid(),newdate);
		a.setAid(aid);
		result = ad.UpdateAppointmentDate(a);
		if(result)
			System.out.println("Appointment Updated Successfully. ");
		else
			System.out.println("Appointment Not Updated Successfully. ");
	}

							
	public void showAllAppointments()
	{
		li = ad.getAllAppointments();
		if(li.isEmpty()) {
			System.out.println("We don't have any appointments!");
			return;
		}
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
}
