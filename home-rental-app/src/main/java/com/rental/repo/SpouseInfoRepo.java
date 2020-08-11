package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.SpouseInfo;

@Repository
public interface SpouseInfoRepo extends JpaRepository<SpouseInfo, Long> {
	

}
