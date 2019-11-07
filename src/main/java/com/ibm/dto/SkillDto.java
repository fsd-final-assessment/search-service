package com.ibm.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {
	
	private Integer id;
	
	@NotNull
	private String name;
	
	private String toc;
	
	private String prerequites;
	
	private String status;
	
}
