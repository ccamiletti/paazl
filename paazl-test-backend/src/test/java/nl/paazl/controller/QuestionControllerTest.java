package nl.paazl.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import nl.paazl.dto.QuestionDTO;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {
	

	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/services/questions";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<QuestionDTO[]> result = restTemplate.getForEntity(uri, QuestionDTO[].class);
	     
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(11, result.getBody().length);
	}
}
