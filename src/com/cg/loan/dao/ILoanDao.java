package com.cg.loan.dao;

import java.util.ArrayList;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.bean.Users;
import com.cg.loan.exception.LoanException;

public interface ILoanDao {


	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException;
	public boolean validateAdmin(Users user) throws LoanException;
	public ArrayList<Application> viewApplications() throws LoanException;
	public boolean deleteLoanProgram(String LoanType) throws LoanException;
	public boolean addLoanProgram(LoanProgramBean loan) throws LoanException;
	public LoanProgramBean retrieveLoanProgram(String type) throws LoanException;
	public Boolean updateLoan(LoanProgramBean loan)  throws LoanException;
}
