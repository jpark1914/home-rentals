package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.BankInfo;
import com.rental.service.BankInfoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/bank")
public class BankInfoController {
	
	public BankInfoService bis;
	
	@Autowired
	public BankInfoController(BankInfoService bis) {
		this.bis = bis;
	}
	
	@PostMapping(value="/save")
	public String saveBankInfo(@RequestBody BankInfo bank) {
		bis.saveBankInfo(bank);
		return "Bank info saved";
	}
	
}
