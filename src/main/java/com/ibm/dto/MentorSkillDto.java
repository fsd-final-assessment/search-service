package com.ibm.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.ibm.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorSkillDto {

	private Integer id;
	
	private Float selfRating;
	
	private Float yearsOfExp;
	
	private BigDecimal price;
	
	private String remarks;
	
	@NotNull
	private String status;
	
	private LocalDateTime createDate;
	
	private User mentor;
	
	private SkillDto skill;

}
