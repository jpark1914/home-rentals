package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.Referral;

@Repository
public interface ReferralRepo extends JpaRepository<Referral, Long> {

}
