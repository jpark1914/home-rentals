package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entity.RentalProps;

public interface RentalPropsRepo extends JpaRepository<RentalProps, Long> {

}
