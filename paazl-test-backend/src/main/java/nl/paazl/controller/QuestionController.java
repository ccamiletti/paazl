package nl.paazl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.paazl.model.QuestionEntity;
import nl.paazl.service.QuestionService;

@RestController
@RequestMapping("services/questions")
public class QuestionController {

	public final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping
	public ResponseEntity<List<QuestionEntity>> findAllQuestions() {
		return new ResponseEntity<List<QuestionEntity>>(this.questionService.findAllQuestions(), HttpStatus.OK);
	}	
	
}
