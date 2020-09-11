package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalUsers;
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
	
	public static final String SAVE_SUCCESS = "Success. Spouse info saved.";
	
	public String saveSpouse(SpouseInfo spouse, RentalUsers rentalUser) {
		SpouseInfo oldSpouse = sir.findSpouseInfoOfUser(rentalUser.getUserId());
		if (oldSpouse != null) {
			spouse.setSpouseId(oldSpouse.getSpouseId());
		} else {
			spouse.setSpouseId(null);
		}
		spouse.setRentalUser(rentalUser);
		sir.save(spouse);
		return SAVE_SUCCESS;
	}
	
	public Optional<SpouseInfo> getSpouseInfo(RentalUsers rentalUser) {
		SpouseInfo si = sir.findSpouseInfoOfUser(rentalUser.getUserId());
		return Optional.ofNullable(si);
	}
	
	
}
