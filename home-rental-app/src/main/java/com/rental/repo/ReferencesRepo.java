package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.References;

@Repository
public interface ReferencesRepo extends JpaRepository<References, Long>{
	
	@Query("SELECT r FROM References r WHERE r.rentalUser.userId = ?1")
	public References findReferencesOfUser(long userId); 
}
