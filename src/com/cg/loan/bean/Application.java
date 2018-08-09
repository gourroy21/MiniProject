package com.cg.loan.bean;

import java.util.Date;

public class Application {
	private int appId;
	private Date appDate;
	private String loanProgram;
	private int amountOfNumber;
	private String addressOfProperty;
	private int annualFamilyIncome;
	private String documentsProofAvailable;
	private String guarenteeCover;
	private int marketValueOfGurarntee;
	private String status;
	private Date dateOfInterview;
	
	
	
	
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
	public int getAmountOfNumber() {
		return amountOfNumber;
	}
	public void setAmountOfNumber(int amountOfNumber) {
		this.amountOfNumber = amountOfNumber;
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
	public int getMarketValueOfGurarntee() {
		return marketValueOfGurarntee;
	}
	public void setMarketValueOfGurarntee(int marketValueOfGurarntee) {
		this.marketValueOfGurarntee = marketValueOfGurarntee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	
	
	
	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appDate=" + appDate + ", loanProgram=" + loanProgram
				+ ", amountOfNumber=" + amountOfNumber + ", addressOfProperty=" + addressOfProperty
				+ ", annualFamilyIncome=" + annualFamilyIncome + ", documentsProofAvailable=" + documentsProofAvailable
				+ ", guarenteeCover=" + guarenteeCover + ", marketValueOfGurarntee=" + marketValueOfGurarntee
				+ ", status=" + status + ", dateOfInterview=" + dateOfInterview + "]";
	}
	
	
}
