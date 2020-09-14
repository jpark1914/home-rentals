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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class OtherInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="OTHER_INFO_SEQ")
	@Column(name="OTHER_ID")
	private Integer otherId;
	
	private transient Long userId;
	
	@Column(name="BANKRUPTCY")
	private Boolean bankruptcy;
	
	@Column(name="EVICT_NOTICE")
	private Boolean evictNotice;

	@Column(name="REFUSED_PAY")
	private Boolean refusedRentPay;
	
	@Column(name="SUED_UNLAWFL_DETAINER")
	private Boolean suedForUnlawfulDetainer;
	
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
