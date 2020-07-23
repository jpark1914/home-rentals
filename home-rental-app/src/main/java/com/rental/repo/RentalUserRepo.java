package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.RentalUsers;

@Repository
public interface RentalUserRepo extends JpaRepository<RentalUsers, Long> {
	public RentalUsers findRentalUsersByEmail(String email);
	
	@Query("SELECT u FROM RentalUsers u WHERE u.password = ?1")
	public RentalUsers passwordExists(String password); 
}
