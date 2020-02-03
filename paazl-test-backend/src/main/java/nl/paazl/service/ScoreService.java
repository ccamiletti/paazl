package nl.paazl.service;

import java.util.Optional;

import nl.paazl.model.ScoreEntity;

public interface ScoreService {

	Optional<ScoreEntity> findResultByScore(Integer range);
	
}
