package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BankInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BANK_ID")
	private int bankId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Column(name="PHONE_NUMBER")
	private long phoneNumber;
	
	@Column(name="BANK_ADDRESS")
	private String bankAddress;
	
	@Column(name="BANK_CITY")
	private String bankCity;
	
	@Column(name="BANK_STATE")
	private String bankState;
	
	@Column(name="BANK_ZIP")
	private int bankZip;
	
	@Column(name="CHECKING_NO")
	private long checkingAccNo;
	
	@Column(name="SAVINGS_NO")
	private long savingsAccNo;
	
	public BankInfo() {
		super();
	}

	public BankInfo(int userId, String bankName, long phoneNumber, String bankAddress, String bankCity,
			String bankState, int bankZip, long checkingAccNo, long savingsAccNo) {
		super();
		this.userId = userId;
		this.bankName = bankName;
		this.phoneNumber = phoneNumber;
		this.bankAddress = bankAddress;
		this.bankCity = bankCity;
		this.bankState = bankState;
		this.bankZip = bankZip;
		this.checkingAccNo = checkingAccNo;
		this.savingsAccNo = savingsAccNo;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankState() {
		return bankState;
	}

	public void setBankState(String bankState) {
		this.bankState = bankState;
	}

	public int getBankZip() {
		return bankZip;
	}

	public void setBankZip(int bankZip) {
		this.bankZip = bankZip;
	}

	public long getCheckingAccNo() {
		return checkingAccNo;
	}

	public void setCheckingAccNo(long checkingAccNo) {
		this.checkingAccNo = checkingAccNo;
	}

	public long getSavingsAccNo() {
		return savingsAccNo;
	}

	public void setSavingsAccNo(long savingsAccNo) {
		this.savingsAccNo = savingsAccNo;
	}

	@Override
	public String toString() {
		return "BankInfo [bankId=" + bankId + ", userId=" + userId + ", bankName=" + bankName + ", phoneNumber="
				+ phoneNumber + ", bankAddress=" + bankAddress + ", bankCity=" + bankCity + ", bankState=" + bankState
				+ ", bankZip=" + bankZip + ", checkingAccNo=" + checkingAccNo + ", savingsAccNo=" + savingsAccNo + "]";
	}
	
}
