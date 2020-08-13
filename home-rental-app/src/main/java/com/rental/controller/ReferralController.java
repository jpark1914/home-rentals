package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.Referral;
import com.rental.service.ReferralService;

@RestController
@CrossOrigin
@RequestMapping(value = "/referral")
public class ReferralController {
	
	private ReferralService rs;
	
	@Autowired
	public ReferralController(ReferralService rs) {
		this.rs = rs;
	}
	
	@PostMapping(value = "/save")
	public String saveReferral(@RequestBody Referral ref) {
		return rs.saveReferral(ref);
	}
}
