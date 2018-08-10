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
import com.cg.loan.exception.LoanException;
import com.cg.loan.util.DBUtil;

public class LoanDao implements ILoanDao{
	 Connection con=null;
	 private static Logger logger=Logger.getRootLogger();
	
	 public LoanDao() {
		 PropertyConfigurator.configure("resources//log4j.properties");
	}
	 
	@Override
	public ArrayList<LoanProgramBean> displayLoanProgram() throws LoanException {
		con=DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<LoanProgramBean> al=new ArrayList<LoanProgramBean>();
		
		//PropertyConfigurator.configure("resources//log4j.properties");
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
	public int addClientDetails(Application app) throws LoanException {
		
		con=DBUtil.getConnection();
		
		if(con == null) {
			logger.fatal("Connection failed");
			throw new LoanException("DataBase connection failed");
			
			}
			int cid = 0;
			
			try {	
			
				PreparedStatement ps = con.prepareStatement(QueryMapper.INSERT_QUERY);	
			
				System.out.println("Check control 1");
				
					
				


				
				
			} catch (SQLException e) {
			
				logger.error("exception occured", e);
				throw new LoanException("Wrong Info");
				
			}
			finally {
				if(con!= null)
					try {
						con.close();
						} 
				catch (SQLException e) {
					logger.error("Please Check Connection", e);
					throw new LoanException("Connection Problem Occured");
					}
				}
			return cid;
	}

}
