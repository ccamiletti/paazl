package nl.paazl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.paazl.model.QuestionEntity;
import nl.paazl.repository.QuestionRepository;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepository questionRepository;
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	@Transactional(readOnly = true)
	public List<QuestionEntity> findAllQuestions() {
		return this.questionRepository.findAll();
	}

}
