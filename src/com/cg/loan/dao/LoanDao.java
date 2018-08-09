package com.cg.loan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.LoanProgramBean;
import com.cg.loan.bean.Users;
import com.cg.loan.exception.LoanException;
import com.cg.loan.util.DBUtil;

public class LoanDao implements ILoanDao{
	 Connection con=DBUtil.getConnection();
	 PreparedStatement ps = null;
	 private static Logger logger=Logger.getRootLogger();
	 
	@Override
	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException {
		
		ResultSet rs=null;
		ArrayList<LoanProgramBean> al=new ArrayList<LoanProgramBean>();
		
		PropertyConfigurator.configure("resources//log4j.properties");
		try {
			ps=con.prepareStatement(QueryMapper.SELECT_QUERY);
			
			rs= ps.executeQuery();
			
			while(rs.next())
				{
					LoanProgramBean l=new LoanProgramBean();
					l.setProgramName(rs.getString(1));
					l.setDescription(rs.getString(2));
					l.setType(rs.getString(3));
					l.setDurationOfYears(rs.getInt(4));
					l.setMinLoanAmount(rs.getDouble(5));
					l.setMaxLoanAmount(rs.getDouble(6));
					l.setRateOfInterest(rs.getDouble(7));
					l.setProofsRequired(rs.getString(8));
					al.add(l);
				}
			
		} catch (SQLException exe) {
			logger.error("Fetching of Loan Programs unsuccessful!"+exe);
			throw new LoanException("Fetching of Loan Programs unsuccessful!");
		}
		return al;
	}

	@Override
	public boolean validateAdmin(Users user) throws LoanException {
		
		try {
			
			ps = con.prepareStatement(QueryMapper.VALIDATE_QUERY);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				return true;
			}
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<Application> viewApplications() throws LoanException {
		ResultSet rs=null;
		ArrayList<Application> t=new ArrayList<>();
		
		try {
			ps=con.prepareStatement(QueryMapper.VIEW_APPLICATIONS_QUERY);
			rs= ps.executeQuery();
						
			while(rs.next())
			{
				Application a=new Application();
				a.setAppId(rs.getInt(1));
				a.setAppDate(rs.getDate(2));
				a.setLoanProgram(rs.getString(3));
				a.setAmountOfNumber(rs.getInt(4));
				a.setAddressOfProperty(rs.getString(5));
				a.setAnnualFamilyIncome(rs.getInt(6));
				a.setDocumentsProofAvailable(rs.getString(7));
				a.setGuarenteeCover(rs.getString(8));
				a.setMarketValueOfGurarntee(rs.getInt(9));
				a.setStatus(rs.getString(10));
				a.setDateOfInterview(rs.getDate(11));
				t.add(a);
			}
			
		} catch (SQLException er) {
			// TODO Auto-generated catch block
			er.printStackTrace();
		}
		return t;
	}

	@Override
	public boolean deleteLoanProgram(String LoanType) throws LoanException {
		
		try {
			ps=con.prepareStatement(QueryMapper.DELETE_LOAN_PROGRAM);
			ps.setString(1, LoanType);
			int k=ps.executeUpdate();
			if(k==1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			throw new LoanException("Enter a valid type of Loan Program!");
		}
	}

	@Override
	public boolean addLoanProgram(LoanProgramBean loan) throws LoanException {
		
		try {
			ps=con.prepareStatement(QueryMapper.FIND_LOAN_PROGRAM);
			ps.setString(1, loan.getType());
			ResultSet rs=null;
			rs=ps.executeQuery();
			
			if(!rs.next())
			{
				PreparedStatement p=con.prepareStatement(QueryMapper.INSERT_LOAN_PROGRAM);
				p.setString(1, loan.getProgramName());
				p.setString(2, loan.getDescription());
				p.setString(3, loan.getType());
				p.setInt(4, loan.getDurationOfYears());
				p.setDouble(5, loan.getMinLoanAmount());
				p.setDouble(6, loan.getMaxLoanAmount());
				p.setDouble(7, loan.getRateOfInterest());
				p.setString(8, loan.getProofsRequired());
				
				int r=p.executeUpdate();
				
				if(r==2) {
					logger.error("Insertion failed");
				}
				else {
					logger.info(r+" rows inserted");
					logger.info("Loan Program details added successfully");
					return true;
				}
			}
			else
			{
				throw new LoanException("Loan Program of this type already exists!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public LoanProgramBean retrieveLoanProgram(String type) throws LoanException {
		LoanProgramBean l=new LoanProgramBean();
		try {
			ps=con.prepareStatement(QueryMapper.FIND_LOAN_PROGRAM);
			ps.setString(1, type);
			ResultSet rs=null;
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				l.setProgramName(rs.getString(1));
				l.setDescription(rs.getString(2));
				l.setType(rs.getString(3));
				l.setDurationOfYears(rs.getInt(4));
				l.setMinLoanAmount(rs.getDouble(5));
				l.setMaxLoanAmount(rs.getDouble(6));
				l.setRateOfInterest(rs.getDouble(7));
				l.setProofsRequired(rs.getString(8));
			}
			else
			{
				throw new LoanException("No loan program of this type exists!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Boolean updateLoan(LoanProgramBean loan) throws LoanException {
		
		try {
			ps=con.prepareStatement(QueryMapper.UPDATE_LOAN_PROGRAM);
			
			ps.setString(1, loan.getProgramName());
			ps.setString(2, loan.getDescription());
			ps.setDouble(3, loan.getDurationOfYears());
			ps.setDouble(4, loan.getMinLoanAmount());
			ps.setDouble(5, loan.getMaxLoanAmount());
			ps.setDouble(6, loan.getRateOfInterest());
			ps.setString(7, loan.getProofsRequired());
			ps.setString(8, loan.getType());
			
			int r=ps.executeUpdate();
						
			if(r==0) {
				System.out.println("Update Failed!");
			}
			else {
				
				System.out.println("Loan Program details added successfully");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
