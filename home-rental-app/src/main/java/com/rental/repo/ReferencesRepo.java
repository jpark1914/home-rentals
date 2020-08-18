package com.rental.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.References;

@Repository
public interface ReferencesRepo extends JpaRepository<References, Long>{
	
	@Query("SELECT r FROM References r WHERE r.rentalUser.userId = ?1")
	public List<References> findReferencesOfUser(long userId); 
	
	@Transactional
	@Modifying
	@Query("DELETE FROM References r WHERE r.rentalUser.userId = ?1")
	public void deleteAllByUserId(long userId);
}
