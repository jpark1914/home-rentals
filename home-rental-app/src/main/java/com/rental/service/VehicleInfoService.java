package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.RentalUsers;
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
	
	public static final String SAVE_SUCCESS = "Success. Vehicles saved.";
	public static final String NUM_VEHICLE_MISMATCH = "Fail. Number of vehicles do not correspond.";
	
	public String updateVehicles(List<VehicleInfo> vehicles, RentalUsers rentalUser) {
		List<VehicleInfo> oldVehicles = vir.findVehicleInfoOfUser(rentalUser.getUserId());
		if (oldVehicles.size() != vehicles.size()) {
			return NUM_VEHICLE_MISMATCH;
		}
		for (int i = 0; i < oldVehicles.size(); i++) {
			vehicles.get(i).setCarId(oldVehicles.get(i).getCarId());
			vehicles.get(i).setRentalUser(rentalUser);
		}
		vir.saveAll(vehicles);
		return SAVE_SUCCESS;
	}
	
	public static final Integer MAX_VEHICLES = 4;
	public static final String TOO_MANY_VEHICLES = "Fail. User can have up to " + MAX_VEHICLES + "vehicles.";
	
	public String addVehicles(List<VehicleInfo> vehicles, RentalUsers rentalUser) {
		List<VehicleInfo> oldVehicles = vir.findVehicleInfoOfUser(rentalUser.getUserId());
		if (oldVehicles.size() >= MAX_VEHICLES) {
			return TOO_MANY_VEHICLES;
		}
		for (VehicleInfo vehicle: vehicles) {
			vehicle.setCarId(null);
			vehicle.setRentalUser(rentalUser);
		}
		vir.saveAll(vehicles);
		return SAVE_SUCCESS;
	}
	
	public static final String DELETE_SUCCESS = "Success. Vehicles Deleted.";
	
	public String deleteVehicles(Integer carId, RentalUsers rentalUser) {
		List<VehicleInfo> oldVehicles = vir.findVehicleInfoOfUser(rentalUser.getUserId());
		for (VehicleInfo vehicle: oldVehicles) {
			if (vehicle.getCarId().equals(carId)) {
				vir.delete(vehicle);
			}
		}
		return DELETE_SUCCESS;
	}
	
	public List<VehicleInfo> getVehicleInfo(RentalUsers rentalUser) {
		return vir.findVehicleInfoOfUser(rentalUser.getUserId());
	}
}
