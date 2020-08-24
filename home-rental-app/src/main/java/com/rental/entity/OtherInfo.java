package com.rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class OtherInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="OTHER_INFO_SEQ")
	@Column(name="OTHER_ID")
	private int otherId;
	
	private transient long userId;
	
	@Column(name="BANKRUPTCY")
	private boolean bankruptcy;
	
	@Column(name="EVICT_NOTICE")
	private boolean evictNotice;

	@Column(name="REFUSED_PAY")
	private boolean refusedRentPay;
	
	@Column(name="SUED_UNLAWFL_DETAINER")
	private boolean suedForUnlawfulDetainer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
//	@Column(name = "REFERRAL_DESC")
//	private String referralDesc;
//	
//	private transient long referralId;
//
//	//Data Model Mappings
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "REFERRAL_ID")
//	private Referral referral;
	
}
