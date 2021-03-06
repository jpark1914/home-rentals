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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
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
	private String appSubmitDate;
	
	@Column
	private String status;
	
	private transient Long userId;
	//Data Model Mappings
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	private transient Long unitId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIT_ID")
	private RentalProps rentalProp;
	
	
}
