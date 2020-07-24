package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.PersonalInfo;
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
	

}
