package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.VehicleInfo;
import com.rental.repo.RentalUserRepo;
import com.rental.repo.VehicleInfoRepo;

@Service
public class VehicleInfoService {
	
	private VehicleInfoRepo vir;
	private RentalUserRepo rur;
	
	@Autowired
	public VehicleInfoService(VehicleInfoRepo vir, RentalUserRepo rur) {
		this.vir = vir;
		this.rur = rur;
	}
	
	public void saveVehicleInfo(VehicleInfo vehicle) {
		vehicle.setRentalUser(rur.findById(vehicle.getUserId()).get());
		vir.save(vehicle);
	}
}
