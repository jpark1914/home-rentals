package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.References;

@Repository
public interface ReferencesRepo extends JpaRepository<References, Long>{
	
}
