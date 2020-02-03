package nl.paazl.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import nl.paazl.dto.QuestionDTO;
import nl.paazl.model.QuestionEntity;

/**
 * Component to mapper from QuestionEntity to QuestionDTO
 * A student can be enrolled in many courses.
 */
@Component
public class QuestionMapperImpl implements QuestionMapper {

	private final ModelMapper modelMapper;

	public QuestionMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public QuestionDTO toDto(QuestionEntity post) {
		return this.modelMapper.map(post, QuestionDTO.class);
	}
	
	public List<QuestionDTO> toDto(List<QuestionEntity> questionList) {
		  return questionList.stream().map(this::toDto).collect(Collectors.toList());
	}

	
	

}
