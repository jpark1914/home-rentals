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
public class BankInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="BANK_SEQ")
	@Column(name="BANK_ID")
	private Integer bankId;
	
	private transient Long userId;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="BANK_ADDRESS")
	private String bankAddress;
	
	@Column(name="BANK_CITY")
	private String bankCity;
	
	@Column(name="BANK_STATE")
	private String bankState;
	
	@Column(name="BANK_ZIP")
	private Integer bankZip;
	
	@Column(name="CHECKING_NO")
	private Long checkingAccNo;
	
	@Column(name="SAVINGS_NO")
	private Long savingsAccNo;
	
	//Model Mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
