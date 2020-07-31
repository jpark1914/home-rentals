package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.PersonalInfo;
import com.rental.service.PersonalInfoService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping("/personal")
public class PersonalInfoController {
	
	public RentalUserService rus;
	public PersonalInfoService pis;
	
	@Autowired
	public PersonalInfoController(RentalUserService rus, PersonalInfoService pis) {
		this.rus = rus;
		this.pis = pis;
	}
	
	@PostMapping(value="/save")
	public void savePersonalInfo(PersonalInfo pi) {
		pis.savePersonalInfo(pi);
	}
	
	@GetMapping(value="/get")
	public PersonalInfo getPersonalInfo(@AuthenticationPrincipal UserDetails user) {
		long userId = rus.findUserByEmail(user.getUsername()).getUserId();
		return pis.getPersonalInfo(userId);
	}

}
