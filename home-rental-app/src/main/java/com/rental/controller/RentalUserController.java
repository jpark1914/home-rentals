package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return rentalUser;
	}
	
	@PostMapping(value = "/save")
	public String newUser(@RequestBody RentalUsers user) {
		user.setUserId(null);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		rus.save(user);
		return "Success";
	}
	
	@PutMapping(value = "/update")
	public RentalUsers updateUser(@RequestBody RentalUsers rentalUser, @AuthenticationPrincipal UserDetails user) {
		RentalUsers newRentalUser = this.rus.findUserByEmail(user.getUsername());
		newRentalUser.setEmail(rentalUser.getEmail());
		newRentalUser.setPassword(passwordEncoder.encode(rentalUser.getPassword()));
		newRentalUser.setIsAdmin(rentalUser.getIsAdmin());
		this.rus.save(newRentalUser);
		return newRentalUser;
	}
	
}
