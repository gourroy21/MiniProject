package com.cg.loan.client;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	static LocalDate today = LocalDate.now();
	
	public static void main(String[] args) {
		int opt,loanId;
		boolean v1,v2;
		
		
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
					System.out.println("Customer Details Page");
					System.out.println("***********************************");
					
					getCustomerDetails();
					v1=service.isValid(cust);
					if(v1)
					{
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
		
		
	}
	
}
	

