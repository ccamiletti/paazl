package nl.paazl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.paazl.model.ScoreEntity;
import nl.paazl.service.ScoreService;

@RestController
@RequestMapping("/services/score")
public class ScoreController {
	
	public final ScoreService scoreService;
	
	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@GetMapping("/getDeveloperLevel/{score}")
	public ResponseEntity<ScoreEntity> getDeveloperLevel(@PathVariable(name = "score") Integer score) throws Exception {
		ScoreEntity scoreEntity = this.scoreService.findResultByScore(score).orElseThrow(() -> new Exception());
		return new ResponseEntity<ScoreEntity>(scoreEntity, HttpStatus.OK);
	}

}
