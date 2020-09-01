package com.rental.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.RentalProps;

@Repository
public interface RentalPropsRepo extends JpaRepository<RentalProps, Integer> {

	@Query("SELECT rp from RentalProps rp WHERE rp.rentalUser.userId = ?1")
	public Page<RentalProps> findRentalPropsByUserId(Long userId, Pageable pageable);
}
