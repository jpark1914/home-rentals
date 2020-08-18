package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.OtherInfo;

@Repository
public interface OtherInfoRepo extends JpaRepository<OtherInfo, Long> {
	
	@Query("SELECT o FROM OtherInfo o WHERE o.rentalUser.userId = ?1")
	public OtherInfo findOtherInfoOfUser(long userId); 
	

}
