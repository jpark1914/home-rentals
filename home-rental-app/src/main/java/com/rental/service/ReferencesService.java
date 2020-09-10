package com.rental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.References;
import com.rental.entity.RentalUsers;
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
	
	private static final Integer MAX_REFS = 10;
	public static final String SAVE_SUCCESS =  "Success. References Saved.";
	public static final String TOO_MANY_REFS = "Fail. User cannot have more than" +  MAX_REFS + " references.";
	
	public String addRefs(List<References> refs, RentalUsers rentalUser) {
		List<References> oldRefs = this.refR.findReferencesOfUser(rentalUser.getUserId());
		if (oldRefs.size() == MAX_REFS) {
			return TOO_MANY_REFS;
		}
		for (References ref : refs) {
			ref.setRefId(null);
			ref.setRentalUser(rentalUser);
		}
		refR.saveAll(refs);
		return SAVE_SUCCESS;
	}
	
	public static final String NUM_REF_MISMATCH = "Fail. Number of References do not correspond.";
	
	public String updateRefs(List<References> refs, RentalUsers rentalUser) {
		List<References> oldRefs = this.refR.findReferencesOfUser(rentalUser.getUserId());
		if (oldRefs.size() != refs.size()) {
			return NUM_REF_MISMATCH;
		}
		for (int i = 0; i < oldRefs.size(); i++) {
			refs.get(i).setRefId(oldRefs.get(i).getRefId());
			refs.get(i).setRentalUser(rentalUser);
		}
		refR.saveAll(refs);
		return SAVE_SUCCESS;
	}
	
	public static final String DELETE_SUCCESS =  "Success. References Deleted.";
	
	public String deleteRef(List<References> refs, RentalUsers rentalUser) {
		List<References> oldRefs = this.refR.findReferencesOfUser(rentalUser.getUserId());
		for (References ref : refs) {
			if (oldRefs.contains(ref)) {
				refR.delete(ref);
			}
		}
		return DELETE_SUCCESS;
	}
	
	public List<References> getRef(RentalUsers rentalUser) {
		return refR.findReferencesOfUser(rentalUser.getUserId());
	}
	
}
