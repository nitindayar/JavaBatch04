package com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.DaoIMPL.ServiceDaoIMPL;
import com.Pojo.Service;

public class ServiceTest 
{
	ServiceDaoIMPL cd = new ServiceDaoIMPL();
	boolean result;
	List<Service> li = new ArrayList<Service>();
	@SuppressWarnings("rawtypes")
	Iterator it;
	int sid;
	String sname, scharge;
	Scanner sc = new Scanner(System.in);
	
	public void addService() {
		System.out.println("Enter service name: ");
		sname = sc.next();
		System.out.println("Enter service charge: ");
		scharge = sc.next();
		result = cd.AddService(new Service(sname,scharge));
		if(result)
				System.out.println("Service Added successfully. ");
			else
				System.out.println("Service Not Added successfully. ");
	}	
				
	public void updateService() {
		System.out.println("Enter service id want to update: ");
		sid = sc.nextInt();sc.nextLine();
		System.out.println("Enter new service name: ");
		sname = sc.nextLine();
		System.out.println("Enter new service charge: ");
		scharge = sc.next();
		Service c = new Service(sname,scharge);
		c.setSid(sid);
		result = cd.UpdateService(c);
		if(result)
			System.out.println("Service Updated Successfully. ");
		else
			System.out.println("Service Not Updated Successfully. ");
	}
			
	public void deleteService()
	{
		System.out.println("Enter service id you want to delete: ");
		sid = sc.nextInt();
		result = cd.DeleteService(sid);
		if(result)
			System.out.println("Service Deleted Successfully. ");
		else
			System.out.println("Service Not Deleted Successfully. ");
	}
							
	public void showAllService()
	{
		li = cd.getAllService();
		it = li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}	
}
