package com.cg.loan.service;

import java.util.ArrayList;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Users;
import com.cg.loan.dao.ILoanDao;
import com.cg.loan.dao.LoanDao;

public class LoanService implements ILoanService{
	ILoanDao dao;
	
	public LoanService() {
		dao=new LoanDao();
	}

	@Override
	public boolean validateUser(Users user) {
		
		return dao.validateUser(user);
	}

	@Override
	public ArrayList<Application> getLoanDetails(String loanProgram) {
		
		return dao.getLoanDetails(loanProgram);
	}

	@Override
	public Application updateStatus(int id,String status) {
		// TODO Auto-generated method stub
		return dao.updateStatus(id,status);
	}
	

}
