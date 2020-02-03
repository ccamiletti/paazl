package main;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import nl.paazl.model.QuestionEntity;
import nl.paazl.model.ScoreEntity;


public class OpenCli {

    private static final String BASE_URL = "http://localhost:8080/services";

	public List<QuestionEntity> getQuestions() {
		List<QuestionEntity> questionList = new ArrayList<QuestionEntity>();
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    URI uri = new URI(BASE_URL.concat("/questions"));	     
		    ResponseEntity<QuestionEntity[]> result = restTemplate.getForEntity(uri, QuestionEntity[].class);
		    questionList = Arrays.stream(result.getBody()).collect(Collectors.toList());
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return questionList;
	}

	public Optional<ScoreEntity> getDeveloperLevel(Integer score) throws Exception {
		Optional<ScoreEntity> scoreOptional = Optional.empty();
		try {
			RestTemplate restTemplate = new RestTemplate();			
		    URI uri = new URI(BASE_URL.concat("/score/getDeveloperLevel/" + score));	     
		    ResponseEntity<ScoreEntity> scoreResponse = restTemplate.getForEntity(uri, ScoreEntity.class);
		    scoreOptional = Optional.of(scoreResponse.getBody());
		}catch(Exception e) {
			throw e;
		}
    	return scoreOptional; 
	}

	private Integer readQuestions() {
		final Scanner scanner = new Scanner(System.in);
	    AtomicInteger ai = new AtomicInteger(0);
	    this.getQuestions().forEach(question -> {
	        System.out.println(question.getQuestion());
	    	if (question.getAnwser().equals(scanner.next().charAt(0))) {
	    		ai.getAndIncrement();
	    	}
	    });
	    return ai.get();
	}

	public static void main(String[] args) {
		OpenCli openCli = new OpenCli();
		try {
			Integer score = openCli.readQuestions();
			String description = openCli.getDeveloperLevel(score)
										.map(ScoreEntity::getDescription)
										.orElseThrow(() -> new Exception());
			System.out.println("Your got " + score + " correct answers, you are a " + description);
		}catch(Exception e) {
	        System.out.println("Sorry, there was an error getting your score");
		}
			
	}
	
	
}
