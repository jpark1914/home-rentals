package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.References;
import com.rental.repo.ReferencesRepo;
import com.rental.repo.RentalUserRepo;

@Service
public class ReferencesService {
	private ReferencesRepo refR;
	private RentalUserRepo rur;
	
	@Autowired
	public void setReferencesRepo(ReferencesRepo refR) {
		this.refR = refR;
	}
	
	@Autowired
	public void setRur(RentalUserRepo rur) {
		this.rur = rur;
	}
	
	public String saveRef(References ref) {
		ref.setRentalUsers(rur.findById(ref.getUserId()).get());
		refR.save(ref);
		return "Reference saved";
	}
	
}
