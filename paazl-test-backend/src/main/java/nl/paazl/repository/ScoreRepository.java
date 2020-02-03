package nl.paazl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.paazl.model.ScoreEntity;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

	@Query("select s from ScoreEntity s where s.rangeInit <= :score and s.rangeEnd >= :score")
	Optional<ScoreEntity> findResultByScore(@Param("score") Integer score);

}
