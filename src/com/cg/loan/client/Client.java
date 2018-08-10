package com.cg.loan.client;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.loan.bean.Application;

import com.cg.loan.bean.Customer;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.bean.Users;
import com.cg.loan.exception.LoanException;

import com.cg.loan.bean.Users;

import com.cg.loan.service.ILoanService;
import com.cg.loan.service.LoanService;

public class Client {

	static Scanner sc= new Scanner(System.in);
	static Customer cust=new Customer();
	static Application app=new Application();
<<<<<<< HEAD
	static LoanProgramBean lb=new LoanProgramBean();
	static Application app;
	static ILoanService service;
	static Scanner sc;
	
	
		

	
	

	public static void main(String[] args) {
		int opt;
		Users user;
		boolean v1;
=======
	static LocalDate today = LocalDate.now();
	
	public static void main(String[] args) {
		int opt,loanId;
		boolean v1,v2;
		
		
>>>>>>> application
		ILoanService service=new LoanService();
		int loginflag=0;
		sc= new Scanner(System.in);
		

		while(true)
		{
			
			System.out.println("*****************************"
					+ "\nLOAN APPLICATION"
					+ "\n******************************"
					+ "\n\n1: Apply For Loan"
					+ "\n2:Login"
					+ "\n3:View Loan Application status.");
					+ "\n4:Exit");
			opt=sc.nextInt();
			switch(opt)
			{
			case 1:
				try {
					
					ArrayList<LoanProgramBean> a=service.displayLoanProgram();
					System.out.println("Select a loan program");
					System.out.println("***********************************");
					int i=1;
					for(LoanProgramBean p:a)
					{
						System.out.println(i+" "+p);
						i++;
					}
					int option=sc.nextInt();
					System.out.println("Customer Details Page");
					System.out.println("***********************************");
					
					getCustomerDetails();
					v1=service.isValid(cust);
					if(v1)
					{
<<<<<<< HEAD
						getApplicationDetails();
=======
						System.out.println("Application Details Page");
						System.out.println("***********************************");
						
						getApplicationDetails(a.get(option-1).getProgramName());
						double min = (a.get(option-1).getMinLoanAmount());
						double max = (a.get(option-1).getMaxLoanAmount());
						v2 = service.isValidApplication(app,min,max);
						if (v2)
						{
							System.out.println("successful");
							
						}
>>>>>>> application
					}
				} catch (LoanException ex) {
					// TODO Auto-generated catch block
					System.out.println(ex.getMessage());
				}

				applyLoan();
				break;
			case 2:
				int opt1;
				System.out.println("Please Choose your Role :\n1)Loan Application Deparment\n2)Admin");
				opt1=sc.nextInt();
				user=new Users();
				service=new LoanService();
				switch(opt1) {
					case 1:
						LoginLad();
						break;
					case 2:
						user.setRole("admin");
						System.out.println("Enter User Name :");
						user.setName(sc.next());
						System.out.println("Enter Password :");
						user.setPassword(sc.next());
					try {
						boolean valid=service.validateAdmin(user);
						if(valid)
						{
							 loginflag=1;
							
							System.out.println("Select an option:\n1.View Applications\n2.Manage Loan Programs");
							int opt2;
							opt2=sc.nextInt();
							switch(opt2)
							{
							case 1: ArrayList<Application> ap=new ArrayList<>();
									ap=service.viewApplications();
									System.out.println("Loan Applications:");
									for(Application a:ap)
									{
										System.out.println(a);
									}
									break;
							case 2: System.out.println("Select the operation:\n1.Add\n2.Edit\n3.Delete\n4.View");
							 		int opt3=sc.nextInt();
							 		int k;
							 		switch(opt3)
							 		{
							 		case 1:k=0;
							 			lb=getLoanProgramDetails(k);
							 			valid=service.addLoanProgram(lb);
							 			if(valid)
							 			{
							 				System.out.println("Loan Program details inserted successfully!!");
							 			}
							 			break;
							 		case 2:System.out.println("Enter type of Loan Program to be edited:");
						 		 		String type=sc.next();
						 		 		LoanProgramBean lp=service.retrieveLoanProgram(type);
						 		 		System.out.println(lp);
						 		 		System.out.println("Enter New Loan Program Details:");
						 		 		k=1;
						 		 		LoanProgramBean g=getLoanProgramDetails(k);
						 		 		g.setType(type);
						 		 		valid=service.isValidLoanProgram(g);
							 			if(valid)
							 			{
							 				Boolean update=service.updateLoan(g);
							 			}
							 			break;
							 			
							 		case 3:System.out.println("Enter type of Loan Program to be deleted:");
							 		 	String LoanType=sc.next();
							 		 	boolean deleted=service.deleteLoanProgram(LoanType);
							 		 	if(deleted)
							 		 	{
							 		 		System.out.println("Loan program of type "+LoanType+" deleted successfully!");
							 		 	}
							 			break;
							 		case 4:ArrayList<LoanProgramBean> a=service.displayLoanProgram();
							 			System.out.println("Loan Programs");
							 			System.out.println("***********************************");
							 			int i=1;
							 			for(LoanProgramBean p:a)
							 			{
							 				System.out.println(i+" "+p);
							 				i++;
							 			}
							 			break;					
							 		}
							}
						}
						
					} catch (LoanException ex) {
						
						System.out.println(ex.getMessage());
					}
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

	public static void getCustomerDetails()
	{
		
		System.out.println("Enter name:");
		cust.setCustomerName(sc.next());
		System.out.println("Enter date of birth (dd/mm/yyyy):");
		cust.setDateOfBirth(sc.next());
		System.out.println("Enter marital status: (married/single)");
		cust.setMaritalStatus(sc.next());
		System.out.println("Enter phone number:");
		cust.setPhoneNo(sc.next());
		System.out.println("Enter mobile number:");
		cust.setMobileNo(sc.next());
		System.out.println("Enter count of dependencies:");
		cust.setCountOfDependencies(sc.nextInt());
		System.out.println("Enter email id:");
		cust.setEmailId(sc.next());
	}
	
	public static void getApplicationDetails()
	{
<<<<<<< HEAD
=======
		
		app.setLoanProgram(loanProgram);

//		Date d1 = Date.valueOf(today);
//		app.setAppDate(d1);
		System.out.println("Enter Loan Amount:");
		app.setAmountOfLoan(sc.nextInt());
		System.out.println("Enter Property Address: ");
		app.setAddressOfProperty(sc.next());
		System.out.println("Enter Annual family Income:");
		app.setAnnualFamilyIncome(sc.nextInt());
		System.out.println("Enter Document Proof Available:");
		app.setDocumentsProofAvailable(sc.next());
		System.out.println("Enter Guarentee Cover:");
		app.setGuarenteeCover(sc.next());
		System.out.println("Enter Market Value Of Gurarntee:");
		app.setMarketValueOfGurarntee(sc.next());
		
>>>>>>> application
		
	}
	public static LoanProgramBean getLoanProgramDetails(int k)
	{
		LoanProgramBean loan=new LoanProgramBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Program Name:");
		loan.setProgramName(sc.next());
		System.out.println("Enter the description:");
		sc.nextLine();
		loan.setDescription(sc.nextLine());
		if(k!=1)
		{
		System.out.println("Enter program type:");
		loan.setType(sc.next());
		}
		System.out.println("Enter duration of years:");
		loan.setDurationOfYears(sc.nextInt());
		System.out.println("Enter Minimum Loan amount:");
		loan.setMinLoanAmount(sc.nextDouble());
		System.out.println("Enter Maximum Loan amount:");
		loan.setMaxLoanAmount(sc.nextDouble());
		System.out.println("Enter Rate of Interest:");
		loan.setRateOfInterest(sc.nextDouble());
		System.out.println("Enter Proofs required:");
		loan.setProofsRequired(sc.next());
		return loan;
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
