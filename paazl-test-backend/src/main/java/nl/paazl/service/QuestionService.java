package nl.paazl.service;

import java.util.List;

import nl.paazl.model.QuestionEntity;

public interface QuestionService {

	List<QuestionEntity> findAllQuestions();
}
