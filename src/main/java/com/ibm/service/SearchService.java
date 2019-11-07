package com.ibm.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ibm.dto.MentorSkillDto;
import com.ibm.dto.SearchTrainingResultDto;

import javassist.NotFoundException;

public interface SearchService {

	List<SearchTrainingResultDto> getUserTrainings(@Param("username") String username) throws NotFoundException;
	
	List<SearchTrainingResultDto> getMentorTrainings(@Param("username") String username) throws NotFoundException;
	
	List<MentorSkillDto> searchMentorSkill(@Param("skillName") String skillName)throws NotFoundException;
	
	
}
