package com.cg.loan.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Customer;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.bean.Users;
import com.cg.loan.exception.LoanException;
import com.cg.loan.service.ILoanService;
import com.cg.loan.service.LoanService;

public class Client {
	static Scanner sc= new Scanner(System.in);
	static Customer cust=new Customer();
	static Application app=new Application();
	static LoanProgramBean lb=new LoanProgramBean();
	
	public static void main(String[] args) {
		int opt;
		boolean v1;
		Users user;
		ILoanService service=new LoanService();
		int loginflag=0;
		while(true)
		{
			
			System.out.println("*****************************"
					+ "\nLOAN APPLICATION"
					+ "\n******************************"
					+ "\n\n1: Apply For Loan"
					+ "\n2:Login"
					+ "\n3:View Loan Application status.");
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
					getCustomerDetails();
					v1=service.isValid(cust);
					if(v1)
					{
						getApplicationDetails();
					}
				} catch (LoanException ex) {
					// TODO Auto-generated catch block
					System.out.println(ex.getMessage());
				}
				break;
			case 2:
				int opt1;
				System.out.println("Please Choose your Role :\n1)Loan Application Deparment\n2)Admin");
				opt1=sc.nextInt();
				user=new Users();
				service=new LoanService();
				
				switch(opt1) {
					case 1:
						user.setRole("lad");
						System.out.println("Enter User Name :");
						user.setName(sc.next());
						System.out.println("Enter Password :");
						user.setPassword(sc.next());
						/*boolean valid=service.validateUser(user);
						if(valid) {
							int opt2;
					
							System.out.println("Choose type of Loan Program");
							System.out.println("\n1)Loan For Purchase"
									+ "\n2)Loan For Construction"
									+ "\n3)Loan For Extension"
									+ "\n4)Loan For Renovation");
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
								}
							}
						else {
							System.out.println("Invalid Credentials Please Try Again");
						}
						break;*/
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
	

