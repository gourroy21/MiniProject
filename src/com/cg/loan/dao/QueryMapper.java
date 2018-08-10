package com.cg.loan.dao;

public class QueryMapper {
public static final String SELECT_QUERY="SELECT * FROM LoanProgramsOffered" ;
public static final String INSERT_QUERY="INSERT INTO LoanApplication VALUES (custid_seq.nextval,sysdate,?,?,?,?,?,?,?,?,?)";
}
