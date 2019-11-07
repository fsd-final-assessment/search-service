package com.ibm.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "toc", length = 100)
	private String toc;
	
	@Column(name = "prerequites", length = 512)
	private String prerequites;
	
	@Column(name = "status", length = 100)
	private String status;
	
	@Column(name = "create_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP")
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updateDate;
	
}
