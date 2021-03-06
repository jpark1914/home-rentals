package com.rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class RentalProps {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PROP_SEQ")
	@Column
	private Integer unitId;	
	
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
	private Double rentAmount;
	
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
	private Integer term;
	
	@Column
	private String ownerFirstName;
	@Column
	private String ownerLastName;
	@Column
	private String ownerFullAddress;
	@Column
	private String ownerEmail;
	@Column
	private Integer ownerPhone;
	
	private transient Long userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
