package nl.paazl.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import nl.paazl.dto.ScoreDTO;
import nl.paazl.model.ScoreEntity;

/**
 * Component to mapper from ScoreEntity to ScoreDTO
 * A student can be enrolled in many courses.
 */

@Component
public class ScoreMapperImpl implements ScoreMapper {

	private final ModelMapper modelMapper;
	
	public ScoreMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	@Override
	public ScoreDTO toDto(ScoreEntity scoreEntity) {
		return this.modelMapper.map(scoreEntity, ScoreDTO.class);
	}

	@Override
	public List<ScoreDTO> toDto(List<ScoreEntity> scoreList) {
		return scoreList.stream().map(this::toDto).collect(Collectors.toList());
	}

}
