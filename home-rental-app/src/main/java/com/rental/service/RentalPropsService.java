package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalProps;
import com.rental.repo.RentalPropsRepo;

@Service
public class RentalPropsService {
	
	public RentalPropsRepo rpr;

	@Autowired
	public RentalPropsService(RentalPropsRepo rpr) {
		this.rpr = rpr;
	}
	
	public Page<RentalProps> getRentalProperties(int pageNum) {
		return this.rpr.findAll(PageRequest.of(pageNum, 12, Sort.by("unitId")));
	}
	
	public void saveNewRentalProperty(RentalProps rentalProp) {
		this.rpr.save(rentalProp);
	}
	
	public Optional<RentalProps> getRentalPropertyById(Integer id) {
		return this.rpr.findById(id);
	}
	

}
