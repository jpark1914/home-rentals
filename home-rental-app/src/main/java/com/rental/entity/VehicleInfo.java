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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class VehicleInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAR_SEQ")
	@Column(name="CAR_ID")
	private Integer carId;
	
	private transient Long userId;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="YEAR")
	private int year;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="TAG_NUMBER")
	private String tagNumber;
	
	@Column(name="STATE")
	private String state;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private RentalUsers rentalUser;

}
