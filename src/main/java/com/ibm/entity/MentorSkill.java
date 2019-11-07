package com.ibm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class MentorSkill {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "self_rating")
	private Float selfRating;
	
	@Column(name = "years_of_exp")
	private Float yearsOfExp;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "remarks", length = 512)
	private String remarks;
	
	@Column(name = "status", length = 100)
	private String status;
	
	@Column(name = "create_date")
//	@Temporal(TemporalType.DATE)
	private LocalDateTime createDate;
	
	@Column(name = "update_date", columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP")
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updateDate;
	
	@JoinColumn(name = "mentor_id")
	@ManyToOne
	private User mentor;
	
	@JoinColumn(name = "skill_id")
	@ManyToOne
	private Skill skill;

}
