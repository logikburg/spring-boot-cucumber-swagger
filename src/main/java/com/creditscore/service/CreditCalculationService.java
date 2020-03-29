package com.creditscore.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.creditscore.model.CreditScoreInputs;
import com.creditscore.utils.CreditScoreRules;

@Service
public class CreditCalculationService {

    private final Logger logger = LoggerFactory.getLogger(CreditScoreRules.class);

    // Calculate Credit score
    public int calculateCreditScore(CreditScoreInputs crScoreIn) {
	logger.info("inside calcuateCreditScore");

	// to calculate score call credit rules  
	int _creditScore = CreditScoreRules.getCreditScore(crScoreIn);
	
	logger.info("CreditScoreRules.getCreditScore called");
	return _creditScore;
    }
}