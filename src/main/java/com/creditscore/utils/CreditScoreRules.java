package com.creditscore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditscore.model.CreditScoreInputs;

public class CreditScoreRules {

    private final static Logger logger = LoggerFactory.getLogger(CreditScoreRules.class);

    public static int getCreditScore(CreditScoreInputs crScoreIn) {
	int _creditScore = 0;

	logger.info("inside getCreditScore");

	logger.info("CompanyType() " + crScoreIn.getCompanyType());
	String companyType = crScoreIn.getCompanyType().toLowerCase();

	if (companyType.contentEquals(CompanyType.SOLE_PROPRIETORYSHIPT.getCompanyType())) {
	    _creditScore += 12;
	} else if (companyType.contentEquals(CompanyType.LLC.getCompanyType())) {
	    _creditScore += 63;
	} else if (companyType.contentEquals(CompanyType.PARTNERSHIP.getCompanyType())) {
	    _creditScore += 75;
	} else if (companyType.contentEquals(CompanyType.OTHERS.getCompanyType())) {
	    _creditScore += 0;
	} else if (companyType.isEmpty()) {
	    _creditScore += 0;
	} else {
	    _creditScore += 0;
	}

	logger.info("NumberOfEmployees() " + crScoreIn.getNumberOfEmployees());

	if (crScoreIn.getNumberOfEmployees() >= 1 && crScoreIn.getNumberOfEmployees() <= 5) {
	    _creditScore += 0;
	} else if (crScoreIn.getNumberOfEmployees() >= 6 && crScoreIn.getNumberOfEmployees() <= 10) {
	    _creditScore += 20;
	} else if (crScoreIn.getNumberOfEmployees() >= 11 && crScoreIn.getNumberOfEmployees() <= 15) {
	    _creditScore += 32;
	} else if (crScoreIn.getNumberOfEmployees() >= 16 && crScoreIn.getNumberOfEmployees() <= 20) {
	    _creditScore += 55;
	} else if (crScoreIn.getNumberOfEmployees() >= 21) {
	    _creditScore += 70;
	} else {
	    _creditScore += 0;
	}

	logger.info("TimeInBusiness() " + crScoreIn.getTimeInBusiness());

	if (crScoreIn.getTimeInBusiness() >= 0 && crScoreIn.getTimeInBusiness() <= 3) {
	    _creditScore += 0;
	} else if (crScoreIn.getTimeInBusiness() >= 4 && crScoreIn.getTimeInBusiness() <= 9) {
	    _creditScore += 28;
	} else if (crScoreIn.getTimeInBusiness() >= 10 && crScoreIn.getTimeInBusiness() <= 15) {
	    _creditScore += 36;
	} else if (crScoreIn.getTimeInBusiness() >= 16) {
	    _creditScore += 59;
	} else {
	    _creditScore += 0;
	}

	logger.debug("total credit score " + _creditScore);

	return _creditScore;
    }

}

enum CompanyType {
    SOLE_PROPRIETORYSHIPT("sole proprietorship"), 
    LLC("limited liability company"), 
    PARTNERSHIP("partnership"),
    OTHERS("others");

    private String companyType;

    CompanyType(String companyType) {
	this.companyType = companyType;
    }

    public String getCompanyType() {
	return companyType;
    }
}

// List<String> CompanyType = {"Sole proprietorship", "Limited Liability Company", "Partnership", "Others"};
// int[] NumberEmployees = {0, 5, 10, 15, 20};
// int[] TimeBusiness = {-1, 3, 9, 15};