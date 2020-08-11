package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.BankInfo;

@Repository
public interface BankInfoRepo extends JpaRepository<BankInfo, Long> {

}
