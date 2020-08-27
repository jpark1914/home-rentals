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

import com.rental.entity.RentalProps;
import com.rental.entity.RentalUsers;
import com.rental.service.RentalPropsService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping(value="/rentalprops")
public class RentalPropsController {
	
	private RentalPropsService rps;
	private RentalUserService rus;

	@Autowired
	public RentalPropsController(RentalPropsService rps, RentalUserService rus) {
		this.rps = rps;
		this.rus = rus;
	}
	
	@GetMapping(value = "/getPage/{pageNum}")
	public ResponseEntity<Page<RentalProps>> getRentalPropsPage(@PathVariable Integer pageNum) {
		return ResponseEntity.ok(this.rps.getRentalPropertiesUnauthorized(pageNum));
	}
	
	@GetMapping(value = "/getPageAdmin/{pageNum}")
	public ResponseEntity<Page<RentalProps>> getAdminRentalPropsPage(@PathVariable Integer pageNum, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		return ResponseEntity.ok(this.rps.getRentalPropertiesByAdmin(rentalUser.getUserId(), pageNum));
	}
	
	@GetMapping(value="/get/{unitId}")
	public ResponseEntity<RentalProps> getRentalProps(@PathVariable Integer unitId, @AuthenticationPrincipal UserDetails user) {
		Optional<RentalProps> oprp = this.rps.getRentalPropertyById(unitId);
		if (!oprp.isPresent()) {	
			return ResponseEntity.noContent().build();
		} 
		RentalUsers rentalUser = this.rus.findUserByUserDetails(user);
		if (!this.rps.propertyOwner(oprp.get(), rentalUser)) {
			oprp = this.rps.getRentalPropertyByIdUnauthorized(unitId);
			return ResponseEntity.status(203).body(oprp.get());
		}	
		return ResponseEntity.ok(oprp.get());

	}
	
	@PostMapping(value = "/save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> saveRentalProps(@RequestBody RentalProps rentalProp, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = this.rus.findUserByEmail(user.getUsername());
		rentalProp.setRentalUser(rentalUser);
		this.rps.saveNewRentalProperty(rentalProp);
		return ResponseEntity.ok("Success");
	}
	
	
		
}