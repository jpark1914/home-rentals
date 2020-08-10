package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.PersonalInfo;

@Repository
public interface PersonalInfoRepo extends JpaRepository<PersonalInfo, Long>{
	
	@Query("SELECT p FROM PersonalInfo p WHERE p.rentalUser.userId = ?1")
	public PersonalInfo findPersonalInfoOfUser(long userId); 
}
