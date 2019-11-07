package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.MentorSkill;

public interface MentorSkillRepository extends JpaRepository<MentorSkill, Integer> {
	
	List<MentorSkill> findBySkillNameIgnoreCaseLikeOrderBySelfRatingDesc(String name);
}
