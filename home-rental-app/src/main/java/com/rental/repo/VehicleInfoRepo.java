package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.VehicleInfo;

@Repository
public interface VehicleInfoRepo extends JpaRepository<VehicleInfo, Long> {

	@Query("SELECT v FROM VehicleInfo v WHERE v.rentalUser.userId = ?1")
	public VehicleInfo findVehicleInfoOfUser(long userId);
}
