package com.rental.entity;

import java.util.Date;

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
@Table(name="PERSONAL_INFO")
@Data
public class PersonalInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PERSONAL_SEQ")
	@Column
	private Integer personId;

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Long phoneNumber;
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String dateOfBirth;
	
	@Column
	private String driverLicense;
	@Column(unique = true)
	private Long ssn;
	
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private Integer zip;
	@Column
	private Integer timeAtPresentAddr;
	@Column
	private String landlord;
	@Column
	private long landlordPhone;
	
	@Column
	private String contactPersonFName;
	@Column
	private String contactPersonLName;
	@Column
	private Long contactPersonPhone;
	
	@Column
	private String employer;
	@Column
	private String occupation;
	@Column
	private Double currentSalary;
	@Column
	private Integer timeEmployed;
	
	@Column
	private String priorAddress;
	@Column
	private String priorCity;
	@Column
	private String priorState;
	@Column
	private String priorZip;
	@Column
	private Integer timeAtPriorAddr;
	
	
	private transient Long userId;
	// Make instance of class to make reference to that classes Primary Key	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;

}
