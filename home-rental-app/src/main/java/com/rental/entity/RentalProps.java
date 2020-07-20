package com.rental.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RentalProps {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UNIT_ID")
	private int unitId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="TERM")
	private int term;
	
	@Column(name="RENT")
	private double rent;
	
	
	public RentalProps() {
		super();
	}

	public RentalProps(int userId, Date startDate, int term, double rent) {
		super();
		this.userId = userId;
		this.startDate = startDate;
		this.term = term;
		this.rent = rent;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
