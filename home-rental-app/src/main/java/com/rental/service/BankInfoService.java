package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.BankInfo;
import com.rental.entity.RentalUsers;
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
	
	public static final String SAVE_SUCCESS = "Success. Bank info saved.";
	
	public String saveBankInfo(BankInfo bankInfo, RentalUsers rentalUser) {
		BankInfo oldBankInfo = bir.findBankInfoOfUser(rentalUser.getUserId());
		if (oldBankInfo != null) {
			bankInfo.setBankId(oldBankInfo.getBankId());
		} else {
			bankInfo.setBankId(null);
		}
		bankInfo.setRentalUser(rentalUser);
		bir.save(bankInfo);
		return SAVE_SUCCESS;
	}
	
	public Optional<BankInfo> getBankInfo(RentalUsers rentalUser) {
		BankInfo bi = bir.findBankInfoOfUser(rentalUser.getUserId());
		return Optional.ofNullable(bi);
	}

}
