package com.cg.loan.dao;

public class QueryMapper {
public static final String SELECT_QUERY="SELECT * FROM LoanProgramsOffered" ;
public static final String VALIDATE_QUERY="SELECT login_id,password,role FROM users WHERE login_id=? AND password=? AND role=?";
public static final String VIEW_APPLICATIONS_QUERY="SELECT * FROM loanapplication" ;
public static final String DELETE_LOAN_PROGRAM="DELETE FROM LoanProgramsOffered WHERE type=?";
public static final String FIND_LOAN_PROGRAM="SELECT * FROM LoanProgramsOffered WHERE type=?";
public static final String INSERT_LOAN_PROGRAM="INSERT INTO LoanProgramsOffered VALUES(?,?,?,?,?,?,?,?)";
public static final String UPDATE_LOAN_PROGRAM="UPDATE LoanProgramsOffered SET program_name=?,description=?,durationinyears=?,minloanamount=?,maxloanamount=?,rateofinterest=?,proofs_required=? WHERE type=?";
}
