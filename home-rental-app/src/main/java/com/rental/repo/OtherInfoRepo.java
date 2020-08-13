package com.rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entity.OtherInfo;

@Repository
public interface OtherInfoRepo extends JpaRepository<OtherInfo, Long> {

}
