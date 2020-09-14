package com.rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class References {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="REFERENCE_SEQ")
	@Column(name="REF_ID")
	private Integer refId;
	
	private transient Long userId;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
