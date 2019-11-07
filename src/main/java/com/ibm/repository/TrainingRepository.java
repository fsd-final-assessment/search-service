package com.ibm.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.dto.SearchTrainingResultDto;
import com.ibm.entity.Training;
import com.ibm.entity.User;

public interface TrainingRepository extends JpaRepository<Training, Integer> {

	@Query("select new com.ibm.dto.SearchTrainingResultDto(" +
			"t.id as trainingId,t.rating,t.startDate,t.endDate,t.status,t.createDate," +
			"s.name as skillName,s.toc as skillToc,s.prerequites as skillPrerequites," +
			"u.username as userUsername,u.firstName as userFirstName,u.lastName as userLastName,u.contactNumber as userContactNumber," +
			"m.username as mentorUsername,m.firstName as mentorFirstName,m.lastName as mentorLastName,m.contactNumber as mentorContactNumber,m.linkedinUrl)" +
			"from Training t, User u, User m, Skill s where t.user.id = u.id AND t.mentor.id = m.id AND t.skill.id = s.id and u.username = :username order by t.createDate desc")
	List<SearchTrainingResultDto> getUserTrainings(@Param("username") String username);
	
	@Query("select new com.ibm.dto.SearchTrainingResultDto(" +
			"t.id as trainingId,t.rating,t.startDate,t.endDate,t.status,t.createDate," +
			"s.name as skillName,s.toc as skillToc,s.prerequites as skillPrerequites," +
			"u.username as userUsername,u.firstName as userFirstName,u.lastName as userLastName,u.contactNumber as userContactNumber," +
			"m.username as mentorUsername,m.firstName as mentorFirstName,m.lastName as mentorLastName,m.contactNumber as mentorContactNumber,m.linkedinUrl)" +
			"from Training t, User u, User m, Skill s where t.user.id = u.id AND t.mentor.id = m.id AND t.skill.id = s.id and m.username = :username order by t.createDate desc")
	List<SearchTrainingResultDto> getMentorTrainings(@Param("username") String username);
	
	@Query("select new com.ibm.dto.SearchTrainingResultDto(" +
			"t.id as trainingId,t.rating,t.startDate,t.endDate,t.status,t.createDate," +
			"s.name as skillName,s.toc as skillToc,s.prerequites as skillPrerequites," +
			"u.username as userUsername,u.firstName as userFirstName,u.lastName as userLastName,u.contactNumber as userContactNumber," +
			"m.username as mentorUsername,m.firstName as mentorFirstName,m.lastName as mentorLastName,m.contactNumber as mentorContactNumber,m.linkedinUrl)" +
			"from Training t, User u, User m, Skill s where t.user.id = u.id AND t.mentor.id = m.id AND t.skill.id = s.id and LOWER(s.name) like %:skillName% order by t.rating desc")
	List<SearchTrainingResultDto> searchTrainingsBySkillName(@Param("skillName") String skillName,Pageable pageable);
}
