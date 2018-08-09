package com.cg.loan.service;

import java.util.ArrayList;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Users;

public interface ILoanService {

	public boolean validateUser(Users user);

	public ArrayList<Application> getLoanDetails(String loanProgram);

	public Application updateStatus(int id,String status);

}
