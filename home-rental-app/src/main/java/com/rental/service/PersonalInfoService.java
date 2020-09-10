package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;
import com.rental.repo.PersonalInfoRepo;
import com.rental.repo.RentalUserRepo;

@Service
public class PersonalInfoService {
	
	public PersonalInfoRepo pir;
	public RentalUserRepo rur;
	
	@Autowired
	public PersonalInfoService(PersonalInfoRepo pir, RentalUserRepo rur) {
		this.pir = pir;
		this.rur = rur;
	}
	
	
	public static final String SAVE_SUCCESS = "Success. Personal Info saved.";
	
	public String savePersonalInfo(PersonalInfo pi, RentalUsers rentalUser) {
		PersonalInfo oldPi = pir.findPersonalInfoOfUser(rentalUser.getUserId());
		if (oldPi != null) {
			pi.setPersonId(oldPi.getPersonId());
		} else {
			pi.setPersonId(null);
		}
		pi.setRentalUser(rentalUser);
		pir.save(pi);
		return SAVE_SUCCESS;
	}
	
	public Optional<PersonalInfo> getPersonalInfo(RentalUsers rentalUser) {
		PersonalInfo pi = pir.findPersonalInfoOfUser(rentalUser.getUserId());
		return Optional.ofNullable(pi);
	}

	/*
	 * public Optional<PersonalInfo> getPersonalInfoUnauthorized(long userId) {
	 * PersonalInfo pi = pir.findPersonalInfoOfUser(userId);
	 * pi.setDriverLicense(null); pi.setSsn(null);
	 * pi.getRentalUser().setPassword(null); return Optional.ofNullable(pi); }
	 */
	
}
