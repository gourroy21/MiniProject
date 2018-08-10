package com.cg.loan.dao;

import java.util.ArrayList;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.exception.LoanException;

public interface ILoanDao {


	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException;
	int addClientDetails(Application app) throws LoanException;
}
