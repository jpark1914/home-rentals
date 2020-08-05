package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalUsers;
import com.rental.repo.RentalUserRepo;

@Service
public class RentalUserService {
	public RentalUserRepo rur;
	
	@Autowired
	public RentalUserService(RentalUserRepo rur) {
		this.rur = rur;
	}
	
	public RentalUsers findUserByEmail(String email) {
		RentalUsers ru =  rur.findRentalUsersByEmail(email);
		ru.setPassword(null);
		return ru;
	}
	
	public void save(RentalUsers user) {
		rur.save(user);
	}
	
	public long numUsers() {
		return rur.count();
	}
			
}
