package com.rental.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.PersonalInfo;
import com.rental.entity.References;
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
	
	@PostMapping(value = "/save")
	public String saveRefs(@RequestBody References[] references) {
		return refS.saveRef(references);
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<References> getPersonalInfo(@AuthenticationPrincipal UserDetails user) {
		long userId = rus.findUserByEmail(user.getUsername()).getUserId();
		Optional<References> opReferences = refS.getRef(userId);
		if (opReferences.isPresent()) {
			return ResponseEntity.ok(opReferences.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
