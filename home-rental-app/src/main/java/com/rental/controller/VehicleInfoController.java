package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.VehicleInfo;
import com.rental.service.VehicleInfoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/vehicle")
public class VehicleInfoController {

	private VehicleInfoService vis;

	
	@Autowired
	public void setVis(VehicleInfoService vis) {
		this.vis = vis;
	}
	
	@PostMapping(value="/save")
	public String saveVehicleInfo(@RequestBody VehicleInfo vehicle) {
		vis.saveVehicleInfo(vehicle);
		return "Vehicle Information Saved";
	}
	
}
