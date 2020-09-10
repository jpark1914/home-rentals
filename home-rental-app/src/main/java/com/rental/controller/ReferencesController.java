package com.rental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.References;
import com.rental.entity.RentalUsers;
import com.rental.service.ReferencesService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/references")
public class ReferencesController {

	private ReferencesService refS;
	private RentalUserService rus;
	
	@Autowired
	public void setrefS(ReferencesService refS, RentalUserService rus) {
		this.refS = refS;
		this.rus = rus;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addRefs(@RequestBody List<References> references, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		String result = this.refS.addRefs(references, rentalUser);
		if (result.equals(ReferencesService.TOO_MANY_REFS)) {
			return ResponseEntity.status(409).body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateRefs(@RequestBody List<References> references, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		String result = refS.updateRefs(references, rentalUser);
		if (result.equals(ReferencesService.NUM_REF_MISMATCH)) {
			return ResponseEntity.status(409).body(result);
		}
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<List<References>> getPersonalInfo(@AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		List<References> references = refS.getRef(rentalUser);
		if (references.size() != 0) {
			return ResponseEntity.ok(references);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> deleteRefs(@RequestBody List<References> references, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		String result = refS.deleteRef(references, rentalUser);
		return ResponseEntity.ok(result);
	}
}
