package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.RentalUsers;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class RentalUserController {
	
	public RentalUserService rus;
	
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public RentalUserController(RentalUserService rus, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.rus = rus;
	}
	
	@GetMapping(value = "/get")
	public RentalUsers getUser(@AuthenticationPrincipal UserDetails user) {
//		System.out.println(user.getEmail());
		RentalUsers rentalUser = rus.findUserByEmail(user.getUsername());
		rentalUser.setPassword("");
		return rentalUser;
	}
	
	@PostMapping(value = "/save")
	public String newUser(@RequestBody RentalUsers user) {
		RentalUsers newUser = new RentalUsers();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setIsAdmin(user.getIsAdmin());
		rus.save(newUser);
		return "Success";
	}
	
}
