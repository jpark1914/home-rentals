package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.VehicleInfo;

@Repository
public interface VehicleInfoRepo extends JpaRepository<VehicleInfo, Long> {

}
