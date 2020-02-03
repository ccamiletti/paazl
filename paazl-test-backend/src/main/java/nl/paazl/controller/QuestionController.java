package nl.paazl.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.paazl.dto.QuestionDTO;
import nl.paazl.dto.ScoreDTO;
import nl.paazl.mapper.QuestionMapper;
import nl.paazl.mapper.ScoreMapper;
import nl.paazl.service.QuestionService;
import nl.paazl.service.ScoreService;

@RestController
@RequestMapping("services/questions")
public class QuestionController {

	public final QuestionService questionService;
	public final ScoreService scoreService;
	private final QuestionMapper questionMapper;
	private final ScoreMapper scoreMapper;
	
	public QuestionController(QuestionService questionService, ScoreService scoreService, QuestionMapper questionMapper, ScoreMapper scoreMapper) {
		this.questionService = questionService;
		this.scoreService = scoreService;
		this.questionMapper = questionMapper;
		this.scoreMapper = scoreMapper;
	}
	
	@GetMapping
	public ResponseEntity<List<QuestionDTO>> findAllQuestions() {
		return new ResponseEntity<List<QuestionDTO>>(
				this.questionMapper.toDto(this.questionService.findAllQuestions()),HttpStatus.OK);
	}

	@PostMapping("/checkAnswers")
	public ResponseEntity<ScoreDTO> checkAnswers(@RequestBody List<QuestionDTO> questionlist) throws Exception {
		AtomicInteger atomicInt = new AtomicInteger(0);

		this.questionService.findAllQuestions().forEach(questionEntity -> {
				questionlist.stream()
								.filter(questionDTO -> null != questionDTO.getAnwserUser())
								.filter(questionDTO -> questionDTO.getId().equals(questionEntity.getId()))
								.filter(questionDTO -> questionDTO.getAnwserUser().equals(questionEntity.getAnwser()))
								.findAny()
								.ifPresent(questionDTO -> {
									atomicInt.incrementAndGet();
								});
		});

		ScoreDTO scoreDTO = this.scoreService.findResultByScore(atomicInt.get()).map(scoreMapper::toDto)
				.orElseThrow(() -> new Exception());
		scoreDTO.setScore(atomicInt.get());
		return new ResponseEntity<ScoreDTO>(scoreDTO, HttpStatus.OK);
	}
	
}
