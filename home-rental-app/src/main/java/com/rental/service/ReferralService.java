package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.Referral;
import com.rental.repo.ReferralRepo;

@Service
public class ReferralService {
	
	private ReferralRepo rr;
	
	@Autowired
	public ReferralService(ReferralRepo rr) {
		this.rr = rr;
	}
	
	public String saveReferral(Referral referral) {
		rr.save(referral);
		return "Referral saved";
	}
}
