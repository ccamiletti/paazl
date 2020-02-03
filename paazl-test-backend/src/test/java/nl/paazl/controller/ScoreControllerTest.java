package nl.paazl.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import nl.paazl.dto.QuestionDTO;
import nl.paazl.dto.ScoreDTO;
import nl.paazl.utils.QuestionEnum;

@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {

	private static final String END_POINT = "http://localhost:8080/services/questions/checkAnswers";
	
	private List<QuestionDTO> createTestAnswers(){
		AtomicInteger atomicInt = new AtomicInteger(0);
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
    	Stream.of(QuestionEnum.values()).forEach(e -> {
    		QuestionDTO questionDTO = new QuestionDTO();
    		questionDTO.setQuestion(e.text());
    		questionDTO.setId(Long.valueOf(atomicInt.incrementAndGet()));
    		questionDTO.setAnwserUser(e.answer());
    		questionList.add(questionDTO);
    	});
    	
    	return questionList;
		
	}
	
	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = new URI(END_POINT);	     
    	ResponseEntity<ScoreDTO> scoreDTO = restTemplate.postForEntity(uri, this.createTestAnswers(), ScoreDTO.class);
	    Assert.assertEquals(200, scoreDTO.getStatusCodeValue());
	    long score = Long.valueOf(scoreDTO.getBody().getScore()).longValue();
	    Assert.assertEquals(11, score);
	}

	
}
