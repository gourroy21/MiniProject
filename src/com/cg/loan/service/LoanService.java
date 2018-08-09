package com.cg.loan.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Customer;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.bean.Users;
import com.cg.loan.dao.ILoanDao;
import com.cg.loan.dao.LoanDao;
import com.cg.loan.exception.LoanException;

public class LoanService implements ILoanService{

	ILoanDao dao=new LoanDao();
	
	@Override
	public boolean isValid(Customer cust) throws LoanException  {
		Pattern name=Pattern.compile("^[a-zA-Z]+$");
		Matcher mname=name.matcher(cust.getCustomerName());
		if(!mname.matches())
		{
			throw new LoanException("Name must contain only alphabets");
		}
		
		Pattern mobile=Pattern.compile("^[7-9][0-9]{9}$");
		Matcher mmobile=mobile.matcher(cust.getMobileNo());
		if(!mmobile.matches())
		{
			throw new LoanException("Enter valid mobile number");
		}
		
		Pattern phone=Pattern.compile("^[1-9][0-9]{7}$");
		Matcher mphone=phone.matcher(cust.getPhoneNo());
		if(!mphone.matches())
		{
			throw new LoanException("Enter valid phone number");
		}
		Pattern count=Pattern.compile("^[0-9]+$");
		Matcher mcount=count.matcher(Integer.toString(cust.getCountOfDependencies()));
		if(!mcount.matches())
		{
			throw new LoanException("Number of dependencies must be a number");
		}
		Pattern email=Pattern.compile("^[a-z0-9._]+@[a-z]+.[a-z]{2,3}$");
		Matcher memail=email.matcher(cust.getEmailId());
		if(!memail.matches())
		{
			throw new LoanException("Enter valid email");
		}
		/*Pattern status=Pattern.compile("married,single");
		Matcher mstatus=status.matcher(cust.getMaritalStatus());
		if(!mstatus.matches())
		{
			throw new LoanException("Phone number must only contain numbers");
		}*/
		if(!(cust.getMaritalStatus().equals("married") || cust.getMaritalStatus().equals("single")))
		{
			throw new LoanException("Enter valid marital status");
		}
		/*DateTimeFormatter f=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d=LocalDate.parse(cust.getDateOfBirth(),f);
		*/
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		  try {
			Date date = sdf.parse(cust.getDateOfBirth());
		} catch (ParseException ex) {
			throw new LoanException("Enter date in the format dd/mm/yyyy");
			
		} 
		
		return true;
		
	}

	@Override
	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException {
		
		return dao.displayLoanProgram();
	}

	@Override
	public boolean validateAdmin(Users user) throws LoanException {
		
		return dao.validateAdmin(user);
	}

	@Override
	public ArrayList<Application> viewApplications() throws LoanException {
		
		return dao.viewApplications();
	}

	@Override
	public boolean deleteLoanProgram(String LoanType) throws LoanException {
		
		return dao.deleteLoanProgram(LoanType);
	}

	@Override
	public boolean addLoanProgram(LoanProgramBean loan) throws LoanException {
		
		return dao.addLoanProgram(loan);
	}

	@Override
	public LoanProgramBean retrieveLoanProgram(String type) throws LoanException {
		
		return dao.retrieveLoanProgram(type);
	}

	@Override
	public boolean isValidLoanProgram(LoanProgramBean loan) throws LoanException {
		
		
		Pattern progName=Pattern.compile("[a-zA-Z0-9]+");
		Pattern description=Pattern.compile("^[a-zA-Z0-9\\s]+$");
		Pattern durationInYears=Pattern.compile("[0-9]+");
		Pattern minloanAmount=Pattern.compile("[0-9]+");
		Pattern maxLoanAmont=Pattern.compile("[0-9]+");
		Pattern rateOfInterest=Pattern.compile("[0-9]+");
		Pattern proofs=Pattern.compile("[a-zA-Z0-9]+");
		
		Matcher mProg=progName.matcher(loan.getProgramName());
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		Matcher mDesc=description.matcher(loan.getDescription());
		if(!mDesc.matches())
		{
			throw new LoanException("Enter a valid Description");
		}
		
	
		Matcher mDur=durationInYears.matcher(Integer.toString(loan.getDurationOfYears()));
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		Matcher mMin=minloanAmount.matcher(Double.toString(loan.getMinLoanAmount()));
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		Matcher mMax=maxLoanAmont.matcher(Double.toString(loan.getMaxLoanAmount()));
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		Matcher mRate=rateOfInterest.matcher(Double.toString(loan.getRateOfInterest()));
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		Matcher mProof=proofs.matcher(loan.getProofsRequired());
		if(!mProg.matches())
		{
			throw new LoanException("Enter a valid Program Name");
		}
		
		return true;
	}

	@Override
	public Boolean updateLoan(LoanProgramBean loan) throws LoanException {
		
		return dao.updateLoan(loan);
	}

}
