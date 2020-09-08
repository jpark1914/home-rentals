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
	private Integer formId;
	
	@Column(name="NO_OCCUOPANT_ADULTS")
	private Integer numberOccAdults;
	
	@Column(name="NO_OCCUPANT_CHILDREN")
	private Integer numberOccChildren;
	
	@Column(name="NO_PETS")
	private Integer numberPets;
	
	@Column(name="PETS_WEIGHT")
	private Integer petsWeight;
	
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
	
	private transient Long userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIT_ID")
	private RentalProps rentalProp;
	
}
