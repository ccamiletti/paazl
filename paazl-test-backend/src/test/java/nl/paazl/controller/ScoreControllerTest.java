package nl.paazl.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import nl.paazl.model.ScoreEntity;
import nl.paazl.utils.ScoreEnum;

@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {

	private static final String BASE_URL = "http://localhost:8080/services";
	private static final Integer JUNIOR = 2;
	private static final Integer MEDIOR = 7;
	private static final Integer SENIOR = 11;
	
	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();			
		    URI uri = new URI(BASE_URL.concat("/score/getDeveloperLevel/" + JUNIOR));	     
		    ResponseEntity<ScoreEntity> scoreResponse = restTemplate.getForEntity(uri, ScoreEntity.class);

		    Assert.assertEquals(200, scoreResponse.getStatusCodeValue());			
		    Assert.assertEquals(scoreResponse.getBody().getDescription(), ScoreEnum.RANGE_1.description());
	}
	
}

