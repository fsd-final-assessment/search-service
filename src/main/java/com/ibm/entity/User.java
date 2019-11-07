package com.ibm.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "username", length = 100, unique = true)
	private String username;

	@Column(name = "password", length = 300)
	private String password;

	@Column(name = "first_name", length = 100)
	private String firstName;

	@Column(name = "last_name", length = 100)
	private String lastName;

	@Column(name = "contact_number", length = 11)
	private String contactNumber;
	
	@Column(name = "reg_code", length = 11)
	private String regCode;
	
	@Column(name = "status", length = 40)
	private String status;
	
	@Column(name = "roles", length = 100)
	private String roles;
	
	@Column(name = "linkedin_url", length = 128)
	private String linkedinUrl;
	
	@Column(name = "create_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP")
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updateDate;
	
	
}
