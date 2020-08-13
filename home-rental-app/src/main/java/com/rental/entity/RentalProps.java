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

@Entity
@Table
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
	
	@Column(name="RENT")
	private double rent;
	
	public RentalUsers getRentalUser() {
		return rentalUser;
	}
	public void setRentalUser(RentalUsers rentalUser) {
		this.rentalUser = rentalUser;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private RentalUsers rentalUser;
	
	
	public RentalProps() {
		super();
	}
	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "RentalProps [unitId=" + unitId + ", userId=" + userId + ", startDate=" + startDate + ", term=" + term
				+ ", rent=" + rent + "]";
	}

}
