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
	@Column(name="UNIT_ID")
	private int unitId;	

	private transient Long userId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="TERM")
	private int term;
	
	//Make a fk to propDetails
	@Column(name="RENT")
	private double rent;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
}
