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

import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;
import com.rental.entity.VehicleInfo;
import com.rental.service.RentalUserService;
import com.rental.service.VehicleInfoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/vehicle")
public class VehicleInfoController {

	private VehicleInfoService vis;
	public RentalUserService rus;

	
	@Autowired
	public void setVis(VehicleInfoService vis, RentalUserService rus) {
		this.vis = vis;
		this.rus = rus;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<List<VehicleInfo>> addVehicles(@RequestBody List<VehicleInfo> vehicles, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		String result = vis.addVehicles(vehicles, rentalUser);
		if (result.equals(VehicleInfoService.TOO_MANY_VEHICLES)) {
			return ResponseEntity.status(409).body(vis.getVehicleInfo(rentalUser));
		}
		return ResponseEntity.ok(vis.getVehicleInfo(rentalUser));
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<List<VehicleInfo>> updateVehicles(@RequestBody List<VehicleInfo> vehicles, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		String result = vis.updateVehicles(vehicles, rentalUser);
		if (result.equals(VehicleInfoService.NUM_VEHICLE_MISMATCH)) {
			return ResponseEntity.status(409).body(vis.getVehicleInfo(rentalUser));
		}
		return ResponseEntity.ok(vis.getVehicleInfo(rentalUser));
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<List<VehicleInfo>> deleteVehicles(@RequestBody List<VehicleInfo> vehicles, @AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		vis.deleteVehicles(vehicles, rentalUser);
		return ResponseEntity.ok(vis.getVehicleInfo(rentalUser));
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<List<VehicleInfo>> getVehicleInfo(@AuthenticationPrincipal UserDetails user) {
		RentalUsers rentalUser = rus.findUserByUserDetails(user);
		return ResponseEntity.ok(vis.getVehicleInfo(rentalUser));	
	}
	
}
