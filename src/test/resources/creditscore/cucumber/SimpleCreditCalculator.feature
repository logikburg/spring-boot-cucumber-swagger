Feature: Credit Assessment Calculator
  This is a simple credit assessment calculator feature for software engineer candidates
      
  Scenario Outline: Calculate Credit Assessment Score
    When The calculateCreditAssessmentScore API is called with <numberOfEmployees>, <companyType>, <numberOfYearsOperated> parameters
    Then The credit assessment score should match <result>

  Examples:
    | numberOfEmployees | companyType | numberOfYearsOperated | result |
    | 6 | "Sole Proprietorship" | 5 | 60 |
    | 10 | "Limited Liability Company" | 8 | 111 |
    | 0 | "" | 0 | 0 |