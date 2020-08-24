package com.rental.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table
@Data
public class SpouseInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPOUSE_SEQ")
	@Column(name="SPOUSE_ID")
	private int spouseId;
	
	private transient Long userId;
	
	@Column(name="SPOUSE_FIRST_NAME")
	private String spouseFirstName;
	
	@Column(name="SPOUSE_LAST_NAME")
	private String spouseLastName;
	
	@Column(name="DOB")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String DOB;
	
	@Column(name="SPOUSE_PHONE")
	private long spousePhone;
	
	@Column(name="SSN")
	private long ssn;
	
	@Column(name="DRIVER_LICENSE")
	private String driverLicense;
	
	@Column(name="EMPLOYER")
	private String employer;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="SALARY")
	private double salary;
	
	@Column(name="TIME_EMPLOYED")
	private int timeEmployed;
	
	@Column(name="CONTACT_FIRST_NAME")
	private String contactFirstName;


	@Column(name="CONTACT_LAST_NAME")
	private String contactLastName;
	
	@Column(name="CONTACT_PHONE")
	private long contactPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
