package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.SpouseInfo;
import com.rental.repo.RentalUserRepo;
import com.rental.repo.SpouseInfoRepo;

@Service
public class SpouseInfoService {
	
	public SpouseInfoRepo sir;
	public RentalUserRepo rur;
	
	@Autowired
	public SpouseInfoService(SpouseInfoRepo sir, RentalUserRepo rur) {
		this.sir = sir;
		this.rur = rur;
	}
	
	public void saveSpouse(SpouseInfo spouse) {
		spouse.setRentalUser(rur.findById(spouse.getUserId()).get());
		sir.save(spouse);
	}
	
	
}
