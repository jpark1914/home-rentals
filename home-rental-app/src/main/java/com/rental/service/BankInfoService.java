package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.BankInfo;

import com.rental.repo.BankInfoRepo;
import com.rental.repo.RentalUserRepo;

@Service
public class BankInfoService {
	
	private BankInfoRepo bir;
	private RentalUserRepo rur;
	
	@Autowired
	public BankInfoService(BankInfoRepo bir, RentalUserRepo rur) {
		this.bir = bir;
		this.rur = rur;
	}
	
	public void saveBankInfo(BankInfo bank) {
		bank.setRentalUser(rur.findById(bank.getUserId()).get());
		bir.save(bank);
	}
	
	public Optional<BankInfo> getBankInfo(long userId) {
		BankInfo bi = bir.findBankInfoOfUser(userId);
		return Optional.ofNullable(bi);
	}

}
