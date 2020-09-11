package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.OtherInfo;
import com.rental.entity.RentalUsers;
import com.rental.repo.OtherInfoRepo;
import com.rental.repo.RentalUserRepo;

@Service
public class OtherInfoService {
	
	private OtherInfoRepo oir;
	private RentalUserRepo rur;
	
	@Autowired
	public OtherInfoService(OtherInfoRepo oir, RentalUserRepo rur) {
		this.oir = oir;
		this.rur = rur;
	}
	
	public static final String SAVE_SUCCESS = "Success. Other info saved.";
	
	public String saveOtherInfo(OtherInfo otherInfo, RentalUsers rentalUser) {
		OtherInfo oldOtherInfo = oir.findOtherInfoOfUser(rentalUser.getUserId());
		if (oldOtherInfo != null) {
			otherInfo.setOtherId(oldOtherInfo.getOtherId());
		} else {
			otherInfo.setOtherId(null);
		}
		otherInfo.setRentalUser(rentalUser);
		oir.save(otherInfo);
		return SAVE_SUCCESS;
	}
	
	public Optional<OtherInfo> getOtherInfo(RentalUsers rentalUser) {
		OtherInfo oi = oir.findOtherInfoOfUser(rentalUser.getUserId());
		return Optional.ofNullable(oi);
	}
	
	
	
}
