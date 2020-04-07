package com.creditscore.service;


import org.springframework.stereotype.Service;

import com.creditscore.model.CreditScoreInputs;

@Service
public interface ICreditCalculationService {
    
    // Calculate Credit score
    public int calculateCreditScore(CreditScoreInputs crScoreIn);
}