package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Referral {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="REFERRAL_SEQ" )
	@Column(name = "REFERRAL_ID")
	private long referralId;
	
	@Column(name = "REFERRAL_TYPE")
	private String referralType;
	
	
	public Referral() {
		super();
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	@Override
	public String toString() {
		return "Referral [referralId=" + referralId + ", referralType=" + referralType + "]";
	}
	
	
}
