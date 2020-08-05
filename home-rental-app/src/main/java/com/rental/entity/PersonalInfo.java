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

@Entity
@Table(name="PERSONAL_INFO")
public class PersonalInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	@Column
	private int personId;
	
	private transient long userId;
	
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}

	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private long phoneNumber;
	
	@Column(unique = true)
	private long driverLicense;
	
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
	
	
	
	public PersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getter and Setters
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(long driverLicense) {
		this.driverLicense = driverLicense;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
	
	public RentalUsers getRentalUser() {
		return rentalUser;
	}

	public void setRentalUser(RentalUsers rentalUser) {
		this.rentalUser = rentalUser;
	}

	@Override
	public String toString() {
		return "PersonalInfo [personId=" + personId + ", userId=" + userId + ", dateOfbirth=" + dateOfBirth
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", ssn="
				+ ssn + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	

}
