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
	private int personId;
	
	private transient Long userId;

	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String dateOfBirth;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private long phoneNumber;
	
	@Column
	private String driverLicense;
	
	@Column(unique = true)
	private long ssn;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private int zip;
	
	// Make instance of class to make reference to that classes Primary Key	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;

}
