package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RentalApp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FORM_ID")
	private int formId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="PRIOR_ADDR")
	private String priorAddress;
	
	@Column(name="PRIOR_CITY")
	private String priorCity;
	
	@Column(name="PRIOR_STATE")
	private String priorState;
	
	@Column(name="PRIOR_ZIP")
	private String priorZip;
	
	@Column(name="TIME_PRESENT_ADDR")
	private int timeAtPresentAddr;
	
	@Column(name="TIME_PRIOR_ADDR")
	private int timeAtPriorAddr;
	
	@Column(name="PRIOR_LANDLORD")
	private String priorLandlord;
	
	@Column(name="LANDLORD_PHOHE")
	private long landlordPhone;
	
	@Column(name="NO_OCCUOPANT_ADULTS")
	private int numberOccAdults;
	
	@Column(name="NO_OCCUPANT_CHILDREN")
	private int numberOccChildren;
	
	@Column(name="NO_PETS")
	private int numberPets;
	
	@Column(name="PETS_WEIGHT")
	private int petsWeight;
	
	@Column(name="EMPLOYER")
	private String employer;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="CURRENT_SALARY")
	private double currentSalary;
	
	@Column(name="TIME_EMPLOYED")
	private int timeEmployed;
	
	@Column(name="CONTACT_PERSON_FNAME")
	private String contactPersonFName;
	
	@Column(name="CONTACT_PERSON_LNAME")
	private String contactPersonLName;
	
	@Column(name="CONTACT_PERSON_PHONE")
	private long contactPersonPhone;
	
	public RentalApp() {
		super();
	}

	public RentalApp(int userId, String priorAddress, String priorCity, String priorState, String priorZip,
			int timeAtPresentAddr, int timeAtPriorAddr, String priorLandlord, long landlordPhone, int numberOccAdults,
			int numberOccChildren, int numberPets, int petsWeight, String employer, String occupation,
			double currentSalary, int timeEmployed, String contactPersonFName, String contactPersonLName,
			long contactPersonPhone) {
		super();
		this.userId = userId;
		this.priorAddress = priorAddress;
		this.priorCity = priorCity;
		this.priorState = priorState;
		this.priorZip = priorZip;
		this.timeAtPresentAddr = timeAtPresentAddr;
		this.timeAtPriorAddr = timeAtPriorAddr;
		this.priorLandlord = priorLandlord;
		this.landlordPhone = landlordPhone;
		this.numberOccAdults = numberOccAdults;
		this.numberOccChildren = numberOccChildren;
		this.numberPets = numberPets;
		this.petsWeight = petsWeight;
		this.employer = employer;
		this.occupation = occupation;
		this.currentSalary = currentSalary;
		this.timeEmployed = timeEmployed;
		this.contactPersonFName = contactPersonFName;
		this.contactPersonLName = contactPersonLName;
		this.contactPersonPhone = contactPersonPhone;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPriorAddress() {
		return priorAddress;
	}

	public void setPriorAddress(String priorAddress) {
		this.priorAddress = priorAddress;
	}

	public String getPriorCity() {
		return priorCity;
	}

	public void setPriorCity(String priorCity) {
		this.priorCity = priorCity;
	}

	public String getPriorState() {
		return priorState;
	}

	public void setPriorState(String priorState) {
		this.priorState = priorState;
	}

	public String getPriorZip() {
		return priorZip;
	}

	public void setPriorZip(String priorZip) {
		this.priorZip = priorZip;
	}

	public int getTimeAtPresentAddr() {
		return timeAtPresentAddr;
	}

	public void setTimeAtPresentAddr(int timeAtPresentAddr) {
		this.timeAtPresentAddr = timeAtPresentAddr;
	}

	public int getTimeAtPriorAddr() {
		return timeAtPriorAddr;
	}

	public void setTimeAtPriorAddr(int timeAtPriorAddr) {
		this.timeAtPriorAddr = timeAtPriorAddr;
	}

	public String getPriorLandlord() {
		return priorLandlord;
	}

	public void setPriorLandlord(String priorLandlord) {
		this.priorLandlord = priorLandlord;
	}

	public long getLandlordPhone() {
		return landlordPhone;
	}

	public void setLandlordPhone(long landlordPhone) {
		this.landlordPhone = landlordPhone;
	}

	public int getNumberOccAdults() {
		return numberOccAdults;
	}

	public void setNumberOccAdults(int numberOccAdults) {
		this.numberOccAdults = numberOccAdults;
	}

	public int getNumberOccChildren() {
		return numberOccChildren;
	}

	public void setNumberOccChildren(int numberOccChildren) {
		this.numberOccChildren = numberOccChildren;
	}

	public int getNumberPets() {
		return numberPets;
	}

	public void setNumberPets(int numberPets) {
		this.numberPets = numberPets;
	}

	public int getPetsWeight() {
		return petsWeight;
	}

	public void setPetsWeight(int petsWeight) {
		this.petsWeight = petsWeight;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public int getTimeEmployed() {
		return timeEmployed;
	}

	public void setTimeEmployed(int timeEmployed) {
		this.timeEmployed = timeEmployed;
	}

	public String getContactPersonFName() {
		return contactPersonFName;
	}

	public void setContactPersonFName(String contactPersonFName) {
		this.contactPersonFName = contactPersonFName;
	}

	public String getContactPersonLName() {
		return contactPersonLName;
	}

	public void setContactPersonLName(String contactPersonLName) {
		this.contactPersonLName = contactPersonLName;
	}

	public long getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(long contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	@Override
	public String toString() {
		return "RentalApp [formId=" + formId + ", userId=" + userId + ", priorAddress=" + priorAddress + ", priorCity="
				+ priorCity + ", priorState=" + priorState + ", priorZip=" + priorZip + ", timeAtPresentAddr="
				+ timeAtPresentAddr + ", timeAtPriorAddr=" + timeAtPriorAddr + ", priorLandlord=" + priorLandlord
				+ ", landlordPhone=" + landlordPhone + ", numberOccAdults=" + numberOccAdults + ", numberOccChildren="
				+ numberOccChildren + ", numberPets=" + numberPets + ", petsWeight=" + petsWeight + ", employer="
				+ employer + ", occupation=" + occupation + ", currentSalary=" + currentSalary + ", timeEmployed="
				+ timeEmployed + ", contactPersonFName=" + contactPersonFName + ", contactPersonLName="
				+ contactPersonLName + ", contactPersonPhone=" + contactPersonPhone + "]";
	}
	
}
