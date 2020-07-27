package com.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void savePersonalInfo(PersonalInfo pi) {
		pis.savePersonalInfo(pi);
	}
	
	@GetMapping(value="/get/{userid}")
	public PersonalInfo getPersonalInfo(@PathVariable("userid") long userId) {
		return pis.getPersonalInfo(userId);
	}

}
