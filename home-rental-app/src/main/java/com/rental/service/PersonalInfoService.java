package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.PersonalInfo;
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
	
	
	public void savePersonalInfo(PersonalInfo pi) {
		pi.setRentalUser(rur.findById(pi.getUserId()).get());
		pir.save(pi);
	}
	
	public Optional<PersonalInfo> getPersonalInfo(long userId) {
		PersonalInfo pi = pir.findPersonalInfoOfUser(userId);
		return Optional.ofNullable(pi);
	}

	public Optional<PersonalInfo> getPersonalInfoUnauthorized(long userId) {
		PersonalInfo pi = pir.findPersonalInfoOfUser(userId);
		pi.setDriverLicense(null);
		pi.setSsn(null);
		pi.getRentalUser().setPassword(null);
		return Optional.ofNullable(pi);
	}
	
}
