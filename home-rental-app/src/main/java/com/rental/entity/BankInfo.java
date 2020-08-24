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
public class BankInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="BANK_SEQ")
	@Column(name="BANK_ID")
	private int bankId;
	
	private transient Long userId;
	
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
	
	//Model Mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
