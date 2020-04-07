package com.creditscore;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.creditscore.model.CreditScoreInputs;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootRestControllerApplicationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	int generatedTestPort;

	@Test
	public void testCrScoreServiceStatusSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + generatedTestPort + "/credit/calculateCreditScore";
		URI uri = new URI(baseUrl);
		CreditScoreInputs crScoreInputs = new CreditScoreInputs();
		HttpEntity<CreditScoreInputs> request = new HttpEntity<>(crScoreInputs);
		ResponseEntity<String> result = this.testRestTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testCreditScore() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + generatedTestPort + "/credit/calculateCreditScore";
		URI uri = new URI(baseUrl);
		CreditScoreInputs crScoreInputs = new CreditScoreInputs(6, "Sole Proprietorship", 10);
		HttpEntity<CreditScoreInputs> request = new HttpEntity<>(crScoreInputs);
		ResponseEntity<String> result = this.testRestTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(68, Integer.parseInt(result.getBody()));
	}
	
	@Test
	public void testCreditScoreNull() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + generatedTestPort + "/credit/calculateCreditScore";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = this.testRestTemplate.postForEntity(uri, null, String.class);
		Assert.assertEquals(415, result.getStatusCodeValue());
	}
}
