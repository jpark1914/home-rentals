package com.rental.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SpouseInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SPOUSE_ID")
	private int spouseId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="SPOUSE_NAME")
	private String spouseName;
	
	@Column(name="DOB")
	private Date DOB;
	
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
	
	@Column(name="CONTACT_PERSON")
	private String contactPerson;
	
	@Column(name="CONTACT_PHONE")
	private long contactPhone;
	
	public SpouseInfo() {
		super();
	}

	public SpouseInfo(int spouseId, int userId, String spouseName, Date dOB, long spousePhone, long ssn,
			String driverLicense, String employer, String occupation, double salary, int timeEmployed,
			String contactPerson, long contactPhone) {
		super();
		this.spouseId = spouseId;
		this.userId = userId;
		this.spouseName = spouseName;
		DOB = dOB;
		this.spousePhone = spousePhone;
		this.ssn = ssn;
		this.driverLicense = driverLicense;
		this.employer = employer;
		this.occupation = occupation;
		this.salary = salary;
		this.timeEmployed = timeEmployed;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
	}

	public int getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(int spouseId) {
		this.spouseId = spouseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
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

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(long contactPhone) {
		this.contactPhone = contactPhone;
	}
	
}
