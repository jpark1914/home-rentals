package com.rental.controller;

import java.util.Optional;

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

import com.rental.entity.RentalUsers;
import com.rental.entity.SpouseInfo;
import com.rental.service.RentalUserService;
import com.rental.service.SpouseInfoService;


@RestController 
@RequestMapping(value="/spouse")
@CrossOrigin
public class SpouseInfoController {
	
	public SpouseInfoService sis;
	public RentalUserService rus;
	@Autowired
	public SpouseInfoController(SpouseInfoService sis, RentalUserService rus) {
		this.sis = sis;
		this.rus = rus;
	}
	
	@PostMapping("/save")
	public ResponseEntity<SpouseInfo> saveSpouse(@RequestBody SpouseInfo spouse, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		sis.saveSpouse(spouse, rentalUser);
		return ResponseEntity.ok(sis.getSpouseInfo(rentalUser).get());
	}
	
	@GetMapping("/get")
	public ResponseEntity<SpouseInfo> getSpouseInfo(@AuthenticationPrincipal UserDetails user){
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		Optional<SpouseInfo> spSpouse = sis.getSpouseInfo(rentalUser);
		if(spSpouse.isPresent()) {
			return ResponseEntity.ok(spSpouse.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}

}
