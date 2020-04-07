package com.creditscore.service.implementation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.creditscore.model.CreditScoreInputs;
import com.creditscore.service.ICreditCalculationService;
import com.creditscore.utils.CreditScoreRules;

@Service
public class CreditCalculationService implements ICreditCalculationService {

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