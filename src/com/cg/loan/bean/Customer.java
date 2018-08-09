package com.cg.loan.bean;

public class Customer {
	private int applicationId;
	private String customerName;
	private String dateOfBirth;
	private String maritalStatus;
	private String phoneNo;
	private String mobileNo;
	private int countOfDependencies;
	private String emailId;
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getCountOfDependencies() {
		return countOfDependencies;
	}
	public void setCountOfDependencies(int countOfDependencies) {
		this.countOfDependencies = countOfDependencies;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Customer [applicationId=" + applicationId + ", customerName=" + customerName + ", dateOfBirth="
				+ dateOfBirth + ", maritalStatus=" + maritalStatus + ", phoneNo=" + phoneNo + ", mobileNo=" + mobileNo
				+ ", countOfDependencies=" + countOfDependencies + ", emailId=" + emailId + "]";
	}
	
	
	
	

}
