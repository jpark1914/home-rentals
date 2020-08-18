package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.OtherInfo;
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
	
	public String saveOtherInfo(OtherInfo otherInfo) {
		otherInfo.setRentalUser(rur.findById(otherInfo.getUserId()).get());
		oir.save(otherInfo);
		return "Other Information has been saved";
	}
	
	public Optional<OtherInfo> getOtherInfo(long userId) {
		OtherInfo oi = oir.findOtherInfoOfUser(userId);
		return Optional.ofNullable(oi);
	}
	
	
	
}
