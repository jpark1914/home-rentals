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

@Entity
@Table
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
	
//	@Column(name = "REFERRAL_DESC")
//	private String referralDesc;
//	
//	private transient long referralId;
//
//	//Data Model Mappings
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "REFERRAL_ID")
//	private Referral referral;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	public OtherInfo() {
		super();
	}

	
	public RentalUsers getRentalUser() {
		return rentalUser;
	}

	public void setRentalUser(RentalUsers rentalUser) {
		this.rentalUser = rentalUser;
	}


	public int getOtherId() {
		return otherId;
	}

	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isBankruptcy() {
		return bankruptcy;
	}

	public void setBankruptcy(boolean bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	public boolean isEvictNotice() {
		return evictNotice;
	}

	public void setEvictNotice(boolean evictNotice) {
		this.evictNotice = evictNotice;
	}

	public boolean isRefusedRentPay() {
		return refusedRentPay;
	}

	public void setRefusedRentPay(boolean refusedRentPay) {
		this.refusedRentPay = refusedRentPay;
	}

	public boolean isSuedForUnlawfulDetainer() {
		return suedForUnlawfulDetainer;
	}

	public void setSuedForUnlawfulDetainer(boolean suedForUnlawfulDetainer) {
		this.suedForUnlawfulDetainer = suedForUnlawfulDetainer;
	}
	
//	public Referral getReferral() {
//		return referral;
//	}
//	public void setReferral(Referral referral) {
//		this.referral = referral;
//	}
//	
//	public String getReferralDesc() {
//		return referralDesc;
//	}
//
//
//	public void setReferralDesc(String referralDesc) {
//		this.referralDesc = referralDesc;
//	}
//
//
//	public Long getReferralId() {
//		return referralId;
//	}
//
//
//	public void setReferralId(Long referralId) {
//		this.referralId = referralId;
//	}


	@Override
	public String toString() {
		return "OtherInfo [otherId=" + otherId + ", userId=" + userId + ", bankruptcy=" + bankruptcy + ", evictNotice="
				+ evictNotice + ", refusedRentPay=" + refusedRentPay + ", suedForUnlawfulDetainer="
				+ suedForUnlawfulDetainer + ", referral=" +  "]";
	}
	
}
