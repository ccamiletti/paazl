package nl.paazl.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.paazl.model.ScoreEntity;
import nl.paazl.repository.ScoreRepository;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

	public ScoreRepository scoreRepository;
	
	public ScoreServiceImpl(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<ScoreEntity> findResultByScore(Integer range) {		
		return this.scoreRepository.findResultByScore(range);
	}

	
}
