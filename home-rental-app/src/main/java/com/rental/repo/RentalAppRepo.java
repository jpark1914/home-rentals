package com.rental.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.RentalApp;

@Repository
public interface RentalAppRepo extends JpaRepository<RentalApp, Long> {

	@Query("SELECT ra FROM RentalApp ra WHERE ra.rentalUser.userId = ?1")
	public List<RentalApp> findRentalAppById(long userId); 
}
