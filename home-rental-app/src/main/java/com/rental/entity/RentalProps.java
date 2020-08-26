package com.rental.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class RentalProps {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PROP_SEQ")
	@Column
	private int unitId;	
	
	@Column
	private String unitAddress;
	@Column
	private String unitCity;
	@Column 
	private String unitState;
	@Column
	private String unitCountry;
	@Column
	private Integer unitZip;
	
	@Column
	private String unitDescription;
	@Column
	private double rentAmount;
	
	@Column
	private String unitType;
	@Column
	private Double unitSquareFeet;
	@Column
	private Integer unitNumBedrooms;
	@Column
	private Integer unitNumBathrooms;
	@Column
	private String unitWasherDryer;
	
	@Column
	private String unitElectric;
	@Column 
	private String unitWaterSewage;
	@Column
	private String unitHeat;
	@Column
	private String unitAC;
	@Column
	private String unitTrashRecycle;
	@Column
	private String unitWifi;
	
	@Column
	private String status;
	@Column
	private String startDate;
	@Column
	private int term;
	
	private transient Long userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
