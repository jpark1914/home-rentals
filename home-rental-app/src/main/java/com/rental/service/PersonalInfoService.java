package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;
import com.rental.repo.PersonalInfoRepo;

@Service
public class PersonalInfoService {
	
	public PersonalInfoRepo pir;
	
	@Autowired
	public PersonalInfoService(PersonalInfoRepo pir){
		this.pir = pir;
	}
	
	
	public void savePersonalInfo(PersonalInfo pi) {
		pir.save(pi);
	}
	
	public Optional<PersonalInfo> getPersonalInfo(long userId) {
		PersonalInfo pi = pir.findPersonalInfoOfUser(userId);
		return Optional.ofNullable(pi);
	}

}
