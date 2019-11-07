package com.ibm.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.MentorSkillDto;
import com.ibm.dto.SearchTrainingResultDto;
import com.ibm.service.impl.SearchServiceImpl;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
@RestController
public class SearchController {
	
private final SearchServiceImpl searchServiceImpl;
	
	public SearchController(SearchServiceImpl searchServiceImpl) {
		this.searchServiceImpl = searchServiceImpl;
	}
	private final static String wildcard = "%%";
	
	@GetMapping("/search/u-trainings")
	ResponseEntity<List<SearchTrainingResultDto>> getUserTrainings(@Valid @RequestParam String username) throws NotFoundException {
		log.info("getUserTrainings:"+username);
		return ResponseEntity.ok(searchServiceImpl.getUserTrainings(username));
	}
	
	@GetMapping("/search/m-trainings")
	ResponseEntity<List<SearchTrainingResultDto>> getMentorTrainings(@Valid @RequestParam String username) throws NotFoundException {
		log.info("getMentorTrainings:"+username);
		return ResponseEntity.ok(searchServiceImpl.getMentorTrainings(username));
	}
	
	@GetMapping("/search/skills")
	ResponseEntity<List<MentorSkillDto>> getTrainings(@RequestParam String skill) throws NotFoundException {
		log.info("getTrainings:"+skill);
		String name = StringUtils.isEmpty(skill) ? wildcard : skill;
		return ResponseEntity.ok(searchServiceImpl.searchMentorSkill(name));
	}
}
