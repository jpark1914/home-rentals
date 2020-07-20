package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class References {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REF_ID")
	private int refId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="REF_FIRST_NAME")
	private String refFirstName;
	
	@Column(name="REF_LAST_NAME")
	private String refLastName;
	
	@Column(name="RELATIONSHIP")
	private String relationship;
	
	@Column(name="PHONE_NO")
	private long phoneNo;
	
	@Column(name="CREDIT_GRANTOR")
	private String creditGrantor;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP")
	private int zip;
	
	@Column(name="GRANTOR_NO")
	private long grantorNo;
	
	public References() {
		super();
	}

	public References(int userId, String refFirstName, String refLastName, String relationship, long phoneNo,
			String creditGrantor, String address, String city, String state, int zip, long grantorNo) {
		super();
		this.userId = userId;
		this.refFirstName = refFirstName;
		this.refLastName = refLastName;
		this.relationship = relationship;
		this.phoneNo = phoneNo;
		this.creditGrantor = creditGrantor;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.grantorNo = grantorNo;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRefFirstName() {
		return refFirstName;
	}

	public void setRefFirstName(String refFirstName) {
		this.refFirstName = refFirstName;
	}

	public String getRefLastName() {
		return refLastName;
	}

	public void setRefLastName(String refLastName) {
		this.refLastName = refLastName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCreditGrantor() {
		return creditGrantor;
	}

	public void setCreditGrantor(String creditGrantor) {
		this.creditGrantor = creditGrantor;
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

	public long getGrantorNo() {
		return grantorNo;
	}

	public void setGrantorNo(long grantorNo) {
		this.grantorNo = grantorNo;
	}

	@Override
	public String toString() {
		return "References [refId=" + refId + ", userId=" + userId + ", refFirstName=" + refFirstName + ", refLastName="
				+ refLastName + ", relationship=" + relationship + ", phoneNo=" + phoneNo + ", creditGrantor="
				+ creditGrantor + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", grantorNo=" + grantorNo + "]";
	}

}
