package com.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalApp;
import com.rental.repo.RentalAppRepo;

@Service
public class RentalAppService {

	private RentalAppRepo rap;
	
	@Autowired
	public RentalAppService(RentalAppRepo rap) {
		this.rap = rap;
	}
	
	public List<RentalApp> getByUserId(long userId) {
		return this.rap.findRentalAppById(userId);
	}
	
	public void save(RentalApp ra) {
		this.rap.save(ra);
	}
}
