package com.cg.loan.dao;

import com.cg.loan.bean.Application;
import com.cg.loan.bean.Users;
import com.cg.loan.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoanDao implements ILoanDao{
	private Connection con;
	private PreparedStatement preparedStatement;
	
	public LoanDao() {
		con=DBUtil.getConnection();
	}

	@Override
	public boolean validateUser(Users user) {
	
		try {
			
			preparedStatement = con.prepareStatement(QueryMapper.VALIDATE_QUERY);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) 
			{
				return true;
			}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<Application> getLoanDetails(String loanProgram) {
		ArrayList<Application> list=new ArrayList<>();
		Application app;
		try {
			preparedStatement = con.prepareStatement(QueryMapper.LOANDETAILS_QUERY);
			preparedStatement.setString(1,loanProgram);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				
			app=new Application();
			
			app.setAppId(rs.getInt(1));
			app.setAppDate(rs.getDate(2));
			app.setLoanProgram(rs.getString(3));
			app.setAmountOfNumber(rs.getInt(4));
			app.setAddressOfProperty(rs.getString(5));
			app.setAnnualFamilyIncome(rs.getInt(6));
			app.setDocumentsProofAvailable(rs.getString(7));
			app.setGuarenteeCover(rs.getString(8));
			app.setMarketValueOfGurarntee(rs.getInt(9));
			app.setStatus(rs.getString(10));
			app.setDateOfInterview(rs.getDate(11));
			list.add(app);
			
			}
			return list;
		}
		catch (Exception e) {
			
		}
		
		
		return list;
	}

	@Override
	public Application updateStatus(int id,String status) {
		System.out.println("Entered in doa update\n");
		Application app=new Application();
		try {
			preparedStatement = con.prepareStatement(QueryMapper.LOANSTATUS_QUERY);
			preparedStatement.setString(1,status);
			preparedStatement.setInt(2,id);
			int update=preparedStatement.executeUpdate();
			System.out.println(update);
			System.out.println(id+status);
			if(update==1) 
			{
				preparedStatement=con.prepareStatement(QueryMapper.GETDETAILS_QUERY);
				preparedStatement.setInt(1,id);
				ResultSet rs=preparedStatement.executeQuery();
				if(rs.next()) 
				{
				app.setAppId(rs.getInt(1));
				app.setAppDate(rs.getDate(2));
				app.setLoanProgram(rs.getString(3));
				app.setAmountOfNumber(rs.getInt(4));
				app.setAddressOfProperty(rs.getString(5));
				app.setAnnualFamilyIncome(rs.getInt(6));
				app.setDocumentsProofAvailable(rs.getString(7));
				app.setGuarenteeCover(rs.getString(8));
				app.setMarketValueOfGurarntee(rs.getInt(9));
				app.setStatus(rs.getString(10));
				app.setDateOfInterview(rs.getDate(11));
				return app;
			}
				}
		
	}catch (Exception e) {
		// TODO: handle exception
	}
		return app;
		
 }
	}
