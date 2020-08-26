package com.rental.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalProps;
import com.rental.entity.RentalUsers;
import com.rental.service.PersonalInfoService;
import com.rental.service.RentalPropsService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping(value="/rentalprops")
public class RentalPropsController {
	
	private RentalPropsService rps;
	private RentalUserService rus;
	private PersonalInfoService pis;

	@Autowired
	public RentalPropsController(RentalPropsService rps, RentalUserService rus, PersonalInfoService pis) {
		this.rps = rps;
		this.rus = rus;
		this.pis = pis;
	}
	
	@GetMapping(value = "/getPage/{pageNum}")
	public ResponseEntity<Page<RentalProps>> getRentalPropsPage(@PathVariable Integer pageNum) {
		return ResponseEntity.ok(this.rps.getRentalProperties(pageNum));
	}
	
	@GetMapping(value="/get/{unitId}")
	public ResponseEntity<RentalProps> getRentalProps(@PathVariable Long unitId, @AuthenticationPrincipal UserDetails user) {
		Optional<RentalProps> oprp = this.rps.getRentalPropertyById(unitId);
		
		if (!oprp.isPresent()) {	
			return ResponseEntity.noContent().build();
		} 
		
		RentalProps rp = oprp.get();
		
		if (user == null) {
			rp.getPersonalInfo().setDriverLicense("");
			rp.getPersonalInfo().setSsn(0);
			rp.getPersonalInfo().getRentalUser().setPassword("");
			return ResponseEntity.status(203).body(rp);
		}
		
		RentalUsers rentalUser = this.rus.findUserByEmail(user.getUsername());
		
		if (!rp.getPersonalInfo().getRentalUser().equals(rentalUser)) {
			rp.getPersonalInfo().setDriverLicense("");
			rp.getPersonalInfo().setSsn(0);
			rp.getPersonalInfo().getRentalUser().setPassword("");
			return ResponseEntity.status(203).body(rp);
		}
			
		return ResponseEntity.ok(oprp.get());

	}
	
	@PostMapping(value = "/save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> saveRentalProps(@RequestBody RentalProps rentalProp, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByEmail(user.getUsername());
		Optional<PersonalInfo> opPersonalInfo = this.pis.getPersonalInfo(rentalUser.getUserId());
		if (!opPersonalInfo.isPresent()) {
			return ResponseEntity.ok("Failure. Personal Info not set.");
		}
		rentalProp.setPersonalInfo(opPersonalInfo.get());
		this.rps.saveNewRentalProperty(rentalProp);
		return ResponseEntity.ok("Success");
	}
	
	
		
}