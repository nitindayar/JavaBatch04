package com.Client;

import java.util.Scanner;

import com.Test.AdminTest;
import com.Test.AppointmentTest;
import com.Test.CustomerTest;
import com.Test.ServiceTest;
import com.Test.TechnicianTest;
import com.Pojo.Customer;
public class Driver 
{
	static Scanner sc = new Scanner(System.in);
	static CustomerTest ct = new CustomerTest();
	static TechnicianTest tt = new TechnicianTest();
	static ServiceTest s = new ServiceTest();
	static AppointmentTest at = new AppointmentTest();
	static AdminTest adt = new AdminTest();
	public static void customerProfileMenu() {
		Customer lc = ct.getCustomerLoginObject();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\t"+lc.getCusername()+" Profile DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. View profile");
		System.out.println("2. Update profile");
		System.out.println("3. Delete pofile");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			ct.getCustomerByUsername();
			customerProfileMenu();
		break;
		case 2:
			ct.updateCustomerByUsername();
			customerProfileMenu();
		break;
		case 3:
			ct.deleteCustomerByUsername();
			runMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			customerHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			customerProfileMenu();
		}
	}
	public static void customerServiceMenu() {
		Customer lc = ct.getCustomerLoginObject();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\t"+lc.getCusername()+" Service DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. View services");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			s.showAllService();
			customerServiceMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			customerHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			customerServiceMenu();
		}
	}
	public static void customerAppointmentMenu() {
		Customer lc = ct.getCustomerLoginObject();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\t"+lc.getCusername()+" Appointment DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Make appointment");
		System.out.println("2. View appointment");
		System.out.println("3. Update appointment service");
		System.out.println("4. Update appointment date");
		System.out.println("5. Delete appointment");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			//make appointment
			s.showAllService();
			at.makeAppointment(lc);
			customerAppointmentMenu();
		break;
		case 2:
			//view appointment
			at.getAppointmentByCustomerID(lc);
			customerAppointmentMenu();
		break;
		case 3:
			//update appointment by service
			at.getAppointmentByCustomerID(lc);
			at.updateAppointmentService(lc);
			customerAppointmentMenu();
		break;
		case 4:
			//update appointment by date
			at.getAppointmentByCustomerID(lc);
			at.updateAppointmentDate(lc);
			customerAppointmentMenu();
		break;
		case 5:
			//delete appointment
			at.getAppointmentByCustomerID(lc);
			at.deleteAppointment();
			customerAppointmentMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			customerHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			customerAppointmentMenu();
		}
	}
	public static void customerHomeMenu() {
		Customer lc = ct.getCustomerLoginObject();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\t"+lc.getCusername()+" Home DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Profile");
		System.out.println("2. Service");
		System.out.println("3. Appointment");
		System.out.println("0. Logout");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			customerProfileMenu();
		break;
		case 2:
			customerServiceMenu();
		break;
		case 3:
			customerAppointmentMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			customerMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			customerHomeMenu();
		}
	}
	public static void customerMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tCustomer Login DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			ct.registerCustomer();
			customerMenu();
		break;
		case 2:
			if(ct.loginCustomer()) {
				System.out.println("Login Done Successfully.");
				customerHomeMenu();
			}
			else {
				System.out.println("Invalid Login Credentials!");
				customerMenu();
			}
		break;
		case 0:
			System.out.println("Thank you.");
			runMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			customerMenu();
		}
	}
	public static void runMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tHome DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Customer");
		System.out.println("2. Admin");
		System.out.println("3. Technician");
		System.out.println("0. Logout");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			customerMenu();
		break;
		case 2:
			adminMenu();
		break;
		case 3:
			technicianMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			runMenu();
		}
	}
	
	public static void technicianMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tTechnician Login DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Technician Login");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			if(tt.loginTechnician()) {
				System.out.println("Login Done Successfully.");
				technicianHomeMenu();
			}
			else {
				System.out.println("Invalid Login Credentials!");
				technicianMenu();
			}
		break;
		case 0:
			System.out.println("Thank you.");
			runMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			technicianMenu();
		}
	}
	
	public static void technicianHomeMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tTechnician Home DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. View technicain details");
		System.out.println("2. Update technicain details");
		System.out.println("3. Show technician appointments");
		System.out.println("0. Logout");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			tt.getTechnicianById();
			technicianHomeMenu();
		break;
		case 2:
			tt.updateTechnician();
			technicianHomeMenu();
		break;
		case 3:
			tt.getAppointmentByTechnicianId();
			technicianHomeMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			technicianMenu();
		break;
		default:
			System.out.println("Invalid Choice, please try again!");
			technicianHomeMenu();
		}
	}
	
	public static void main(String args[]) {
		System.out.println("\n\tWelcome to Online Two Wheeler Technician Appointment System");
		runMenu();
		System.out.println("Program completed!, You may now close the concole");
	}
	
	public static void adminCustomerMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Customer DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. View Customers");
		System.out.println("2. Update Customers");
		System.out.println("3. Delete Customer");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			ct.showAllCustomers();
			adminCustomerMenu();
		break;
		case 2:
			ct.showAllCustomers();
			ct.updateCustomer();
			adminCustomerMenu();
		break;
		case 3:
			ct.showAllCustomers();
			ct.deleteCustomer();
			adminCustomerMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			adminHomeMenu();
		break;
		default:
			System.out.println("Invalid Choice, please try again!");
			adminCustomerMenu();
		}
	}
	
	public static void adminTechnicianMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Technician DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Add Technician");
		System.out.println("2. View Technicians");
		System.out.println("3. Update Technician");
		System.out.println("4. Delete Technician");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			tt.addTechnician();
			adminTechnicianMenu();
		break;
		case 2:
			tt.showAllTechnicians();
			adminTechnicianMenu();
		break;
		case 3:
			tt.showAllTechnicians();
			tt.updateTechnicianById();
			adminTechnicianMenu();
		break;
		case 4:
			tt.showAllTechnicians();
			tt.deleteTechnician();
			adminTechnicianMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			adminHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			adminTechnicianMenu();
		}
	}
	
	public static void adminServiceMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Service DashBoard");
		System.out.println("---------------s-----------------------------------------------------------");
		System.out.println("1. View Services");
		System.out.println("2. Update Service");
		System.out.println("3. Delete Service");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			s.showAllService();
			adminServiceMenu();
		break;
		case 2:
			s.showAllService();
			s.updateService();
			adminServiceMenu();
		break;
		case 3:
			s.showAllService();
			s.deleteService();
			adminServiceMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			adminHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			adminServiceMenu();
		}
	}
	
	public static void adminAppointmentMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Appointment DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. View Appointments");
		System.out.println("2. Update Appointment Date");
		System.out.println("3. Update Appointment Service");
		System.out.println("4. Delete Appointments");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			at.showAllAppointments();
			adminAppointmentMenu();
		break;
		case 2:
			at.showAllAppointments();
			at.updateAppointmentDate();
			adminAppointmentMenu();
		break;
		case 3:
			at.showAllAppointments();
			s.showAllService();
			at.updateAppointmentService();
			adminAppointmentMenu();
		break;
		case 4:
			at.showAllAppointments();
			at.deleteAppointment();
			adminAppointmentMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			adminHomeMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			adminAppointmentMenu();
		}
	}
	
	public static void adminHomeMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Home DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Appointment");
		System.out.println("2. Technician");
		System.out.println("3. Service");
		System.out.println("4. Customer");
		System.out.println("0. Logout");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			adminAppointmentMenu();
		break;
		case 2:
			adminTechnicianMenu();
		break;
		case 3:
			adminServiceMenu();
		break;
		case 4:
			adminCustomerMenu();
		break;
		case 0:
			System.out.println("Thank you.");
			adminMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			adminHomeMenu();
		}
	}
	public static void adminMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\tAdmin Login DashBoard");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("1. Login");
		System.out.println("0. Exit");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			if(adt.loginAdmin()) {
				System.out.println("Login Done Successfully.");
				adminHomeMenu();
			}
			else {
				System.out.println("Invalid Login Credentials!");
				adminMenu();
			}
		break;
		case 0:
			System.out.println("Thank you.");
			runMenu();
		break;
		default:
			System.out.println("Invalid choice, please try again!");
			adminMenu();
		}
	}
}
