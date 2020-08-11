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

@Entity
@Table
public class SpouseInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public String getContactFirstName() {
		return contactFirstName;
	}



	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}



	public String getContactLastName() {
		return contactLastName;
	}



	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	@Column(name="CONTACT_LAST_NAME")
	private String contactLastName;
	
	@Column(name="CONTACT_PHONE")
	private long contactPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	public RentalUsers getRentalUser() {
		return rentalUser;
	}



	public void setRentalUser(RentalUsers rentalUser) {
		this.rentalUser = rentalUser;
	}



	public SpouseInfo() {
		super();
	}



	public int getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(int spouseId) {
		this.spouseId = spouseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}
	
	public String getSpouseLastName() {
		return spouseLastName;
	}

	public void setSpouseLastName(String spouseLastName) {
		this.spouseLastName = spouseLastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public long getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(long spousePhone) {
		this.spousePhone = spousePhone;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getTimeEmployed() {
		return timeEmployed;
	}

	public void setTimeEmployed(int timeEmployed) {
		this.timeEmployed = timeEmployed;
	}


	public long getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(long contactPhone) {
		this.contactPhone = contactPhone;
	}
	
}
