package com.ibm.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Integer id;

	@NotNull
	private String username;
	
	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;

	private String contactNumber;
	
	private String regCode;
	
	@NotNull
	private String status;
	
	private String roles;
	
	private String linkedinUrl;
	
	private LocalDateTime createDate;
	
}
