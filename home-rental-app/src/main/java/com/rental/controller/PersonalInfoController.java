package com.rental.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;
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
	public ResponseEntity<PersonalInfo> savePersonalInfo(@RequestBody PersonalInfo pi, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		pis.savePersonalInfo(pi, rentalUser);
		return ResponseEntity.ok(pis.getPersonalInfo(rentalUser).get());
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<PersonalInfo> getPersonalInfo(@AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		Optional<PersonalInfo> opPersonal = pis.getPersonalInfo(rentalUser);
		if (opPersonal.isPresent()) {
			return ResponseEntity.ok(opPersonal.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/*
	 * @GetMapping(value="/getInfo/{userId}") public ResponseEntity<PersonalInfo>
	 * getPersonalInfoOfUser(@PathVariable Long userId) { Optional<PersonalInfo>
	 * opPersonal = pis.getPersonalInfoUnauthorized(userId); if
	 * (opPersonal.isPresent()) { return ResponseEntity.ok(opPersonal.get()); } else
	 * { return ResponseEntity.noContent().build(); } }
	 */

}
