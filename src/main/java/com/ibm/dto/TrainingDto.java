package com.ibm.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDto {
	
	private Integer id;
	  
	private Float rating;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	@NotNull
	private String status;
	
	private LocalDateTime createDate;
	
	private UserDto user;
	
	private UserDto mentor;
	
	private SkillDto skill;
	
}
