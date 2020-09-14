package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Referral {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="REFERRAL_SEQ" )
	@Column(name = "REFERRAL_ID")
	private Long referralId;
	
	@Column(name = "REFERRAL_TYPE")
	private String referralType;
	
}
