package com.cg.loan.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Customer;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.exception.LoanException;
import com.cg.loan.service.ILoanService;
import com.cg.loan.service.LoanService;

public class Client {
	static Scanner sc= new Scanner(System.in);
	static Customer cust=new Customer();
	static Application app=new Application();
	public static void main(String[] args) {
		int opt;
		boolean v1;
		ILoanService service=new LoanService();
		
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
						getApplicationDetails(a.get(option-1).getProgramName());
					}
				} catch (LoanException ex) {
					// TODO Auto-generated catch block
					System.out.println(ex.getMessage());
				}
				break;
			case 2:
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
	
	public static void getApplicationDetails(String loanProgram)
	{
		app.setLoanProgram(loanProgram);
		
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
	
}
	

