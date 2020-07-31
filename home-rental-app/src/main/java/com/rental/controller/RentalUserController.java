package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public RentalUserController(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	public RentalUserController(RentalUserService rus) {
		this.rus = rus;
	}
	
	@PostMapping(value = "/getUser")
	public RentalUsers getUser(@RequestBody RentalUsers user) {
//		System.out.println(user.getEmail());
		return rus.findUserByEmail(user.getEmail(), user.getPassword());
	}
	
	@PostMapping(value = "/newUser")
	public String newUser(@RequestBody RentalUsers user) {
		RentalUsers newUser = new RentalUsers();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setIsAdmin(user.getIsAdmin());
		rus.save(newUser);
		return "Success";
	}
	
}
