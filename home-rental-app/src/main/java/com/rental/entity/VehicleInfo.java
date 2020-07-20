package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VehicleInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_ID")
	private int carId;
	
	@Column(name="USER_ID")
	private int userId;
	
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
	
	public VehicleInfo() {
		super();
	}

	public VehicleInfo(int userId, String make, String model, int year, String color, int tagNumber, String state) {
		super();
		this.userId = userId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.tagNumber = tagNumber;
		this.state = state;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
