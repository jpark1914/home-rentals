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
	public String saveBankInfo(@RequestBody BankInfo bank) {
		bis.saveBankInfo(bank);
		return "Bank info saved";
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<BankInfo> getBankInfo(@AuthenticationPrincipal UserDetails user) {
		long userId = rus.findUserByEmail(user.getUsername()).getUserId();
		Optional<BankInfo> opBank = bis.getBankInfo(userId);
		if (opBank.isPresent()) {
			return ResponseEntity.ok(opBank.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
