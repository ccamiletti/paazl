package nl.paazl.config;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import nl.paazl.model.QuestionEntity;
import nl.paazl.model.ScoreEntity;
import nl.paazl.repository.QuestionRepository;
import nl.paazl.repository.ScoreRepository;
import nl.paazl.utils.QuestionEnum;
import nl.paazl.utils.ScoreEnum;

/**
* Spring Component class to load question and score tables
*/
@Component
public class DataLoader  implements ApplicationRunner {

    private QuestionRepository questionRepository;
    private ScoreRepository scoreRepository;

    @Autowired
    public DataLoader(QuestionRepository questionRepository, ScoreRepository scoreRepository) {
        this.questionRepository = questionRepository;
        this.scoreRepository = scoreRepository;
    }

    private void loadQuestions() {
    	Stream.of(QuestionEnum.values()).forEach(e -> {
    		QuestionEntity questionEntity = new QuestionEntity();
    		questionEntity.setQuestion(e.text());
    		questionEntity.setAnwser(e.answer());
    		this.questionRepository.save(questionEntity);	
    	});
    }
    private void loadScores() {
    	Stream.of(ScoreEnum.values()).forEach(e -> {
    		ScoreEntity scoreEntity = new ScoreEntity();
    		scoreEntity.setDescription(e.description());
    		scoreEntity.setRangeInit(e.rangeInit());
    		scoreEntity.setRangeEnd(e.rangeEnd());
    		this.scoreRepository.save(scoreEntity);	
    	});
    }
    
    public void run(ApplicationArguments args) {
    	this.loadQuestions();      
    	this.loadScores();
    }
}