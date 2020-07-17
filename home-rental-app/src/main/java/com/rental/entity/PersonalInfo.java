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
public class PersonalInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	@Column
	private int personId;
	@Column
	private int userId;
	@Column
	private Date dateOfbirth;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private long phoneNumber;
	@Column
	private long driverLicense;
	@Column
	private long ssn;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int zip;
	
	
	public PersonalInfo( int userId, Date dateOfbirth, String firstName, String lastName, long phoneNumber,
			long driverLicense, long ssn, String address, String city, String state, int zip) {
		super();
		this.userId = userId;
		this.dateOfbirth = dateOfbirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.driverLicense = driverLicense;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public PersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
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
	
	@Override
	public String toString() {
		return "PersonalInfo [personId=" + personId + ", userId=" + userId + ", dateOfbirth=" + dateOfbirth
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", ssn="
				+ ssn + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	

}
