package com.cg.loan.client;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		int opt;
		Scanner sc= new Scanner(System.in);
		
		while(true)
		{
			
			System.out.println("\nLOAN APPLICATION"
					+ "\n******************************"
					+ "\n\n1: Apply For Loan"
					+ "\n2:Login"
					+ "\n3:View Loan Application status.");
			opt=sc.nextInt();
			switch(opt)
			{
			case 1:
				applyLoan();
				break;
			case 2:
				break;
			case 3:
				break;
				default:
					
				
				
			}
				
		}
	}

	public static void applyLoan()
	{
		
	}
}
	

