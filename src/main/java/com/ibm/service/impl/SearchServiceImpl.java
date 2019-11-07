package com.ibm.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ibm.dto.MentorSkillDto;
import com.ibm.dto.SearchTrainingResultDto;
import com.ibm.dto.TrainingDto;
import com.ibm.entity.MentorSkill;
import com.ibm.entity.Training;
import com.ibm.repository.MentorSkillRepository;
import com.ibm.repository.TrainingRepository;
import com.ibm.service.SearchService;

import javassist.NotFoundException;

@Service
public class SearchServiceImpl implements SearchService{
	
	private final TrainingRepository trainingRepository;
	
	private final MentorSkillRepository mentorSkillRepository;
	
	private final ModelMapper modelMapper;
	
	public SearchServiceImpl(TrainingRepository trainingRepository,MentorSkillRepository mentorSkillRepository,ModelMapper modelMapper) {
		this.trainingRepository = trainingRepository;
		this.mentorSkillRepository = mentorSkillRepository;
		this.modelMapper = modelMapper;
	}
	
	public TrainingDto update(Integer id, TrainingDto trainingDto) throws NotFoundException{
		Optional<Training> trainingOpt = trainingRepository.findById(id);
		
		if (!trainingOpt.isPresent()) {
			throw new NotFoundException("User dosen't exist : " + id);
		}
		
		Training training = modelMapper.map(trainingDto, Training.class);
		training.setId(id);
		trainingRepository.save(training);
		trainingDto.setId(training.getId());
		return trainingDto;
	}

	@Override
	public List<SearchTrainingResultDto> getUserTrainings(String username) throws NotFoundException {
		return this.trainingRepository.getUserTrainings(username);
	}

	@Override
	public List<SearchTrainingResultDto> getMentorTrainings(String username) throws NotFoundException {
		return this.trainingRepository.getMentorTrainings(username);
	}

	@Override
	public List<MentorSkillDto> searchMentorSkill(String skillName) throws NotFoundException{
		List<MentorSkill> mentorSkills = this.mentorSkillRepository.findBySkillNameIgnoreCaseLikeOrderBySelfRatingDesc(skillName);
		MentorSkillDto[] mentorSkillDtos = modelMapper.map(mentorSkills, MentorSkillDto[].class);
		return Arrays.asList(mentorSkillDtos);
	}

}
