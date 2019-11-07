package com.ibm.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTrainingResultDto {
	
	//training
	private Integer trainingId;
	  
	private Float rating;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private String status;
	
	private LocalDateTime createDate;
	
	//skill
	private String skillName;
	
	private String skillToc;
	
	private String skillPrerequites;
	
	//user
	private String userUsername;
	
	private String userFirstName;

	private String userLastName;

	private String userContactNumber;
	
	//mentor
	private String mentorUsername;
	
	private String mentorFirstName;

	private String mentorLastName;

	private String mentorContactNumber;
	
	private String linkedinUrl;
}
