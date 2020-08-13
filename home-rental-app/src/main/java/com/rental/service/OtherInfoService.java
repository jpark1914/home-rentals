package com.rental.service;

import org.springframework.stereotype.Service;

import com.rental.entity.OtherInfo;
import com.rental.repo.OtherInfoRepo;
import com.rental.repo.ReferralRepo;
import com.rental.repo.RentalUserRepo;

@Service
public class OtherInfoService {
	
	private OtherInfoRepo oir;
	private RentalUserRepo rur;
	private ReferralRepo rr;
	
	public OtherInfoService(OtherInfoRepo oir, RentalUserRepo rur, ReferralRepo rr) {
		this.oir = oir;
		this.rur = rur;
		this.rr = rr;
	}
	
	public String saveOtherInfo(OtherInfo otherInfo) {
		otherInfo.setRentalUser(rur.findById(otherInfo.getUserId()).get());
		otherInfo.setReferral(rr.findById(otherInfo.getReferralId()).get());
		oir.save(otherInfo);
		return "Other Information has been saved";
	}
	
}
