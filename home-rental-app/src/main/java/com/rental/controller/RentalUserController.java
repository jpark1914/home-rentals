package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.RentalUsers;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class RentalUserController {
	public RentalUserService rus;
	
	@Autowired
	public RentalUserController(RentalUserService rus) {
		this.rus = rus;
	}
	
	@PostMapping(value = "/getUser")
	public RentalUsers getUser(@RequestBody RentalUsers user) {
//		System.out.println(user.getEmail());
		return rus.findUserByEmail(user.getEmail(), user.getPassword());
	}
	
	
}
