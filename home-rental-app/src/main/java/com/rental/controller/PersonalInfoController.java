package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.PersonalInfo;
import com.rental.service.PersonalInfoService;

@RestController
@CrossOrigin
@RequestMapping("/personal")
public class PersonalInfoController {
	
	public PersonalInfoService pis;
	
	@Autowired
	public PersonalInfoController(PersonalInfoService pis) {
		this.pis = pis;
	}
	
	@PostMapping(value="/save")
	public void savePersonalInfo(@RequestBody PersonalInfo pi) {
		pis.savePersonalInfo(pi);
	}
}
