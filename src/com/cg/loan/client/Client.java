package com.cg.loan.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Users;
import com.cg.loan.service.ILoanService;
import com.cg.loan.service.LoanService;

public class Client {
	
	static Application app;
	static ILoanService service;
	static Scanner sc;

	public static void main(String[] args) {
		int opt;
		Users user;
		
		sc= new Scanner(System.in);
		
		while(true)
		{
			
			System.out.println("*****************************"
					+ "\nLOAN APPLICATION"
					+ "\n******************************"
					+ "\n\n1: Apply For Loan"
					+ "\n2:Login"
					+ "\n3:View Loan Application status."
					+ "\n4:Exit");
			opt=sc.nextInt();
			switch(opt)
			{
			case 1:
				applyLoan();
				break;
			case 2:
				int opt1;
				System.out.println("Please Choose your Role :\n1)Loan Application Deparment\n2)Admin");
				opt1=sc.nextInt();
				
				switch(opt1) {
				case 1:
					LoginLad();
					break;
				case 2:
					break;
				default :
					break;
				}
				break;
			case 3:
				break;
			case 4:
				System.exit(0);
				break;
				default:
						
			}
				
		}
	}

	public static void applyLoan()
	{
		
	}
	public static void LAD(String type) {
		sc= new Scanner(System.in);
		app=new Application();
		Application uapp;
		ArrayList<Application> list=new ArrayList<>();
		app.setLoanProgram(type);
		list=service.getLoanDetails(app.getLoanProgram());
		if(!list.isEmpty()) {
			for(Application a:list) {
				System.out.println(a+"\n");
			}
			System.out.println("Select ID to update the status of loan Application");
			int id=sc.nextInt();
			System.out.println("Choose an Option to change the status"
					+ "\n1)Accepted\n2)Rejected\n3)Approved");
			int opt4=sc.nextInt();
			switch(opt4) {
			case 1:
				uapp=service.updateStatus(id,"Accepted");
				System.out.println("Loan Status Updated Sucessfully\n"+uapp);
				break;
			case 2:
				uapp=service.updateStatus(id,"Rejected");
				System.out.println("Loan Status Updated Sucessfully\n"+uapp);
				break;
			case 3:
				uapp=service.updateStatus(id,"Approved");
				System.out.println("Loan Status Updated Sucessfully\n"+uapp);
				break;
			
			default :
				break;
		}
			}
		else System.out.println("No Records Found");
	}
	
public static void LoginLad()
{
	Users user=new Users();
	user.setRole("lad");
	service=new LoanService();
	System.out.println("Enter User Name :");
	user.setName(sc.next());
	System.out.println("Enter Password :");
	user.setPassword(sc.next());
	boolean valid=service.validateUser(user);
	if(valid) {
		int opt2;
		boolean val=true;
		while(val) {
		System.out.println("Choose type of Loan Program");
		System.out.println("\n1)Loan For Purchase"
				+ "\n2)Loan For Construction"
				+ "\n3)Loan For Extension"
				+ "\n4)Loan For Renovation"
				+"\n5)Logout");
		opt2=sc.nextInt();
		
		switch(opt2) {
		case 1:
				LAD("purchase");
			break;	
		case 2:
				LAD("Construction");
			break;
		case 3:
				LAD("Extension");
			break;
		case 4:
			LAD("Rennovation");
			break;
		case 5:
			val=false;
			LoginLad();
			break;
			default:
				System.out.println("Please choose from 1 to 5");
				break;
		}
	}
		}
	else {
		System.out.println("Invalid Credentials Please Try Again");
		LoginLad();
	}
}
}
