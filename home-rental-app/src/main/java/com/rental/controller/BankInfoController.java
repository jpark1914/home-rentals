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

import com.rental.entity.BankInfo;
import com.rental.entity.RentalUsers;
import com.rental.entity.BankInfo;
import com.rental.service.BankInfoService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/bank")
public class BankInfoController {
	
	public BankInfoService bis;
	public RentalUserService rus;
	
	@Autowired
	public BankInfoController(BankInfoService bis, RentalUserService rus) {
		this.bis = bis;
		this.rus = rus;
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<BankInfo> saveBankInfo(@RequestBody BankInfo bankInfo, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		bis.saveBankInfo(bankInfo, rentalUser);
		return ResponseEntity.ok(bis.getBankInfo(rentalUser).get());
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<BankInfo> getBankInfo(@AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		Optional<BankInfo> opBank = bis.getBankInfo(rentalUser);
		if (opBank.isPresent()) {
			return ResponseEntity.ok(opBank.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
