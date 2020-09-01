package com.rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class RentalApp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="APP_SEQ")
	@Column(name="FORM_ID")
	private int formId;
	
	private transient Long userId;
	
	@Column(name="PRIOR_ADDR")
	private String priorAddress;
	
	@Column(name="PRIOR_CITY")
	private String priorCity;
	
	@Column(name="PRIOR_STATE")
	private String priorState;
	
	@Column(name="PRIOR_ZIP")
	private String priorZip;
	
	@Column(name="TIME_PRESENT_ADDR")
	private int timeAtPresentAddr;
	
	@Column(name="TIME_PRIOR_ADDR")
	private int timeAtPriorAddr;
	
	@Column(name="PRIOR_LANDLORD")
	private String priorLandlord;
	
	@Column(name="LANDLORD_PHOHE")
	private long landlordPhone;
	
	@Column(name="NO_OCCUOPANT_ADULTS")
	private int numberOccAdults;
	
	@Column(name="NO_OCCUPANT_CHILDREN")
	private int numberOccChildren;
	
	@Column(name="NO_PETS")
	private int numberPets;
	
	@Column(name="PETS_WEIGHT")
	private int petsWeight;
	
	@Column(name="EMPLOYER")
	private String employer;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="CURRENT_SALARY")
	private double currentSalary;
	
	@Column(name="TIME_EMPLOYED")
	private int timeEmployed;
	
	@Column(name="CONTACT_PERSON_FNAME")
	private String contactPersonFName;
	
	@Column(name="CONTACT_PERSON_LNAME")
	private String contactPersonLName;
	
	@Column(name="CONTACT_PERSON_PHONE")
	private long contactPersonPhone;
	
	@Column
	private String appDate;
	
	@Column
	private String status;
	
	@Column
	private String propertyOwner;
	
	//Data Model Mappings
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIT_ID")
	private RentalProps rentalProp;
	
}
