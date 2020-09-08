package com.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.RentalApp;
import com.rental.entity.RentalUsers;
import com.rental.service.RentalAppService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping("/rentalapp")
public class RentalAppController {

	private RentalUserService rus;
	private RentalAppService ras;
	
	@Autowired
	public RentalAppController(RentalUserService rus, RentalAppService ras) {
		this.rus = rus;
		this.ras = ras;
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<RentalApp>> getRentalApp(@AuthenticationPrincipal UserDetails user){
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		return ResponseEntity.ok(this.ras.getByUserId(rentalUser.getUserId()));
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveRentalApp(@RequestBody RentalApp ra, @AuthenticationPrincipal UserDetails user){
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		ra.setRentalUser(rentalUser);
		this.ras.save(ra);
		
		return ResponseEntity.ok("Success");
	}
	
}
