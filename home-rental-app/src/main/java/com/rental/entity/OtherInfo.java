package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OtherInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OTHER_ID")
	private int otherId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="BANKRUPTCY")
	private boolean bankruptcy;
	
	@Column(name="EVICT_NOTICE")
	private boolean evictNotice;
	
	@Column(name="REFUSED_PAY")
	private boolean refusedRentPay;
	
	@Column(name="SUED_UNLAWFL_DETAINER")
	private boolean suedForUnlawfulDetainer;

	@Column(name="REFERRAL")
	private String referral;
	
	public OtherInfo() {
		super();
	}

	public OtherInfo(int userId, boolean bankruptcy, boolean evictNotice, boolean refusedRentPay,
			boolean suedForUnlawfulDetainer, String referral) {
		super();
		this.userId = userId;
		this.bankruptcy = bankruptcy;
		this.evictNotice = evictNotice;
		this.refusedRentPay = refusedRentPay;
		this.suedForUnlawfulDetainer = suedForUnlawfulDetainer;
		this.referral = referral;
	}

	public int getOtherId() {
		return otherId;
	}

	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	@Override
	public String toString() {
		return "OtherInfo [otherId=" + otherId + ", userId=" + userId + ", bankruptcy=" + bankruptcy + ", evictNotice="
				+ evictNotice + ", refusedRentPay=" + refusedRentPay + ", suedForUnlawfulDetainer="
				+ suedForUnlawfulDetainer + ", referral=" + referral + "]";
	}
	
}
