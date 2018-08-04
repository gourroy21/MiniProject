package com.cg.loan.service;

import java.util.ArrayList;

import com.cg.loan.bean.Customer;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.exception.LoanException;

public interface ILoanService {

	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException;
	public boolean isValid(Customer cust) throws LoanException;
	
}
