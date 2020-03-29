package com.creditscore.model;

public class CreditScoreInputs {
    private String companyType = "";
    private int numberOfEmployees;
    private int timeInBusiness;

    public CreditScoreInputs() {
    }

    public CreditScoreInputs(int numberOfEmployees, String companyType, int timeInBusiness) {
	this.companyType = companyType;
	this.numberOfEmployees = numberOfEmployees;
	this.timeInBusiness = timeInBusiness;
    }

    public String getCompanyType() {
	return companyType;
    }

    public void setCompanyType(String companyType) {
	this.companyType = companyType;
    }

    public int getNumberOfEmployees() {
	return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
	this.numberOfEmployees = numberOfEmployees;
    }

    public int getTimeInBusiness() {
	return timeInBusiness;
    }

    public void setTimeInBusiness(int timeInBusiness) {
	this.timeInBusiness = timeInBusiness;
    }

}
