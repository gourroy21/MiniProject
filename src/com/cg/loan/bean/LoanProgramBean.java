package com.cg.loan.bean;

public class LoanProgramBean {

	private String programName;
	private String description;
	private String type;
	private int durationOfYears;
	private double minLoanAmount;
	private double maxLoanAmount;
	private double rateOfInterest;
	private String proofsRequired;
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDurationOfYears() {
		return durationOfYears;
	}
	public void setDurationOfYears(int durationOfYears) {
		this.durationOfYears = durationOfYears;
	}
	public double getMinLoanAmount() {
		return minLoanAmount;
	}
	public void setMinLoanAmount(double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	public double getMaxLoanAmount() {
		return maxLoanAmount;
	}
	public void setMaxLoanAmount(double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getProofsRequired() {
		return proofsRequired;
	}
	public void setProofsRequired(String proofsRequired) {
		this.proofsRequired = proofsRequired;
	}
	@Override
	public String toString() {
		return "ProgramName=" + programName + ", description=" + description + ", type=" + type
				+ ", durationOfYears=" + durationOfYears + ", minLoanAmount=" + minLoanAmount + ", maxLoanAmount="
				+ maxLoanAmount + ", rateOfInterest=" + rateOfInterest + ", proofsRequired=" + proofsRequired ;
	}
	
	
}
