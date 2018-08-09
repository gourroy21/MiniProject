package com.cg.loan.dao;

public interface QueryMapper {
	public static final String VALIDATE_QUERY="SELECT login_id,password,role FROM users WHERE login_id=? AND password=? AND role=?";
	public static final String LOANDETAILS_QUERY="SELECT * FROM loanapplication where loan_program=?";
	public static final String LOANSTATUS_QUERY="UPDATE loanapplication SET status=? WHERE application_id=?";
	public static final String GETDETAILS_QUERY="select * from loanapplication where application_id=?";
}
