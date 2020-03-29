package com.creditscore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.creditscore.model.CreditScoreInputs;
import com.creditscore.service.CreditCalculationService;

@RestController
@RequestMapping("/credit")
public class CreditCalculationController {

    private final Logger logger = LoggerFactory.getLogger(CreditCalculationController.class);

    @Autowired
    private CreditCalculationService crCalService;

    @PostMapping(path = "/calculateCreditScore")
    @ResponseStatus(HttpStatus.OK)
    public int calculateCreditScore(@RequestBody CreditScoreInputs creditScoreInputs) {
	logger.info("request /calculateCreditScore");
	int _crScore = crCalService.calculateCreditScore(creditScoreInputs);
	logger.info("calculateCreditScore end");
	return _crScore;
    }
}
