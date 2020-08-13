package com.rental.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rental.entity.Referral;
import com.rental.entity.RentalUsers;

@SpringBootTest
public class RepoTests {
	private long id = 8;
	private long ref = 2;
	
	private RentalUserRepo rur;
	private ReferralRepo rr;
	
	@Autowired
	public RepoTests(RentalUserRepo rur, ReferralRepo rr) {
		this.rur = rur;
		this.rr = rr;
	}

	@Test
	public void findUserTest() {
		Optional<RentalUsers> r = rur.findById(this.id);
		System.out.println(r.toString());
		assertEquals(r, r);
	}
	
	@Test
	public void findReferralTest() {
		Optional<Referral> r = rr.findById(this.ref);
		System.out.println(r.toString());
		assertEquals(r, r);
	}
	
}
