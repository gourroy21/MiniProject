package com.cg.loan.bean;

import java.sql.Date;

public class Application {
	private int appId;
	private Date appDate;
	private String loanProgram;
	private int amountOfLoan;
	private String addressOfProperty;
	private int annualFamilyIncome;
	private String documentsProofAvailable;
	private String guarenteeCover;
	private String marketValueOfGurarntee;
	private String status;
	private String dateOfInterview;
	
	
	
	
	public Application() {
		this.status = "Applied"; //Set status as Applied by default
	}
	
	
	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	


	public Date getAppDate() {
		return appDate;
	}


	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}



	public String getLoanProgram() {
		return loanProgram;
	}
	public void setLoanProgram(String loanProgram) {
		this.loanProgram = loanProgram;
	}
	public int getAmountOfLoan() {
		return amountOfLoan;
	}
	
	public void setAmountOfLoan(int amountOfLoan) {
		this.amountOfLoan = amountOfLoan;
	}

	public String getAddressOfProperty() {
		return addressOfProperty;
	}
	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}
	public int getAnnualFamilyIncome() {
		return annualFamilyIncome;
	}
	public void setAnnualFamilyIncome(int annualFamilyIncome) {
		this.annualFamilyIncome = annualFamilyIncome;
	}
	public String getDocumentsProofAvailable() {
		return documentsProofAvailable;
	}
	public void setDocumentsProofAvailable(String documentsProofAvailable) {
		this.documentsProofAvailable = documentsProofAvailable;
	}
	public String getGuarenteeCover() {
		return guarenteeCover;
	}
	public void setGuarenteeCover(String guarenteeCover) {
		this.guarenteeCover = guarenteeCover;
	}
	
	public String getMarketValueOfGurarntee() {
		return marketValueOfGurarntee;
	}



	public void setMarketValueOfGurarntee(String marketValueOfGurarntee) {
		this.marketValueOfGurarntee = marketValueOfGurarntee;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public String getDateOfInterview() {
		return dateOfInterview;
	}



	public void setDateOfInterview(String dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}



	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appDate=" + appDate + ", loanProgram=" + loanProgram
				+ ", amountOfLoan=" + amountOfLoan + ", addressOfProperty=" + addressOfProperty
				+ ", annualFamilyIncome=" + annualFamilyIncome + ", documentsProofAvailable=" + documentsProofAvailable
				+ ", guarenteeCover=" + guarenteeCover + ", marketValueOfGurarntee=" + marketValueOfGurarntee
				+ ", status=" + status + ", dateOfInterview=" + dateOfInterview + "]";
	}



	



	


	


		
	
}
