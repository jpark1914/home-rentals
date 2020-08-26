package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalProps;
import com.rental.entity.RentalUsers;
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
	
	public Page<RentalProps> getRentalPropertiesUnauthorized(int pageNum) {
		Page<RentalProps> page = this.rpr.findAll(PageRequest.of(pageNum, 12, Sort.by("unitId")));
		for (RentalProps rp : page.getContent()) {
			rp.getRentalUser().setPassword(null);
		}
		return page;
	}
	
	public void saveNewRentalProperty(RentalProps rentalProp) {
		this.rpr.save(rentalProp);
	}
	
	public Optional<RentalProps> getRentalPropertyById(Integer id) {
		if (id == null) {
			return Optional.empty();
		}
		return this.rpr.findById(id);
	}
	
	public Optional<RentalProps> getRentalPropertyByIdUnauthorized(Integer id) {
		Optional<RentalProps> opRental = this.getRentalPropertyById(id);
		if (opRental.isPresent()) {
			opRental.get().getRentalUser().setPassword(null);
		}
		return opRental;
	}
	
	public boolean propertyOwner(RentalProps rentalProp, RentalUsers user) {
		if (user == null || rentalProp == null) {
			return false;
		}
		return rentalProp.getRentalUser().getUserId().equals(user.getUserId());
	}
	

}
