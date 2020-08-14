package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entity.BankInfo;
import com.rental.entity.PersonalInfo;

@Repository
public interface BankInfoRepo extends JpaRepository<BankInfo, Long> {

	@Query("SELECT b FROM BankInfo b WHERE b.rentalUser.userId = ?1")
	public BankInfo findBankInfoOfUser(long userId); 
}
