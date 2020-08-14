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
	
	@PostMapping(value="/save")
	public String saveVehicleInfo(@RequestBody VehicleInfo vehicle) {
		vis.saveVehicleInfo(vehicle);
		return "Vehicle Information Saved";
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<VehicleInfo> getVehicleInfo(@AuthenticationPrincipal UserDetails user) {
		long userId = rus.findUserByEmail(user.getUsername()).getUserId();
		Optional<VehicleInfo> vpVehicle = vis.getVehicleInfo(userId);
		if (vpVehicle.isPresent()) {
			return ResponseEntity.ok(vpVehicle.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
