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

@Entity
@Table
public class VehicleInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_ID")
	private int carId;
	
	
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
	private int tagNumber;
	
	@Column(name="STATE")
	private String state;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	public VehicleInfo() {
		super();
	}

	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public RentalUsers getRentalUser() {
		return rentalUser;
	}



	public void setRentalUser(RentalUsers rentalUser) {
		this.rentalUser = rentalUser;
	}



	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "VehicleInfo [carId=" + carId + ", userId=" + userId + ", make=" + make + ", model=" + model + ", year="
				+ year + ", color=" + color + ", tagNumber=" + tagNumber + ", state=" + state + "]";
	}
	
}
