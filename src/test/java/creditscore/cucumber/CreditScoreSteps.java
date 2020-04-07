package creditscore.cucumber;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditscore.controller.CreditCalculationController;
import com.creditscore.model.CreditScoreInputs;
import com.creditscore.service.ICreditCalculationService;
import com.creditscore.service.implementation.CreditCalculationService;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreditScoreSteps {

    private final Logger logger = LoggerFactory.getLogger(CreditCalculationController.class);

    private Integer _creditScore = 0;

    @Before("@Test")
    public void beforeScenario() {
	System.out.println("Scenario default begins");
    }

    @After("@Test")
    public void afterScenario() {
	System.out.println("Scenario default begins");
    }

    @Given("The calculateCreditAssessmentScore API is called with {int}, {string}, {int} parameters")
    public void api_called_with_parameters(int numberOfEmployees, String companyType, int numberOfYearsOperated) {
	logger.info("numberOfEmployees {}, companyType {}, numberOfYearsOperated {}", numberOfEmployees, companyType,
		numberOfYearsOperated);
	CreditScoreInputs crScoreIn = new CreditScoreInputs();
	crScoreIn.setCompanyType(companyType);
	crScoreIn.setNumberOfEmployees(numberOfEmployees);
	crScoreIn.setTimeInBusiness(numberOfYearsOperated);

	Assert.assertNotNull("CompanyType is Null", crScoreIn.getCompanyType());
	Assert.assertNotNull("NumberOfEmployees is NaN", crScoreIn.getNumberOfEmployees());
	Assert.assertNotNull("TimeInBusiness  is NaN", crScoreIn.getTimeInBusiness());

	ICreditCalculationService crCalService = new CreditCalculationService();

	_creditScore = crCalService.calculateCreditScore(crScoreIn);
    }

    @Then("The credit assessment score should match {int}")
    public void the_credit_assessment_score_should_match(Integer result) {
	logger.info("result {}", result);
	Assert.assertEquals("credit score is not matched", result, _creditScore);
    }
}