package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.SpouseInfo;

@Repository
public interface SpouseInfoRepo extends JpaRepository<SpouseInfo, Long> {
	
	@Query("SELECT sp FROM SpouseInfo sp WHERE sp.rentalUser.userId = ?1")
	public SpouseInfo findSpouseInfoOfUser(long userId);

}
