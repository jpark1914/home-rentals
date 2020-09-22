package com.rental.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.rental.authority.AdminAuthority;
import com.rental.authority.UserAuthority;
import com.rental.entity.RentalUsers;
import com.rental.repo.RentalUserRepo;

@ExtendWith(MockitoExtension.class)
public class RentalUserServiceUnitTests {
	
		@Mock
		private RentalUserRepo rur;
		
		@InjectMocks
		private RentalUserService rus;
		
		public UserDetails getAdminUserDetails() {
			ArrayList<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new UserAuthority());
			roles.add(new AdminAuthority());
			return new User("naughtynas@gmail.com", "pass", roles);
		}
		
		public RentalUsers getAdminRentalUser() {
			return new RentalUsers(1L,"naughtynas@gmail.com","pass","ADMIN");
		}
		
		@Test
		public void testFindUsersByEmailCallsRepoMethod() {
			RentalUsers rentalUser = getAdminRentalUser();
			rus.findUserByEmail(rentalUser.getEmail());
			Mockito.verify(rur, times(1)).findRentalUsersByEmail(rentalUser.getEmail());
		}
		
		@Test
		public void testFindUsersByEmailReturnsUser() {
			RentalUsers rentalUser = getAdminRentalUser();
			Mockito.when(rur.findRentalUsersByEmail("naughtynas@gmail.com"))
				.thenReturn(rentalUser);
			assertThat(rus.findUserByEmail("naughtynas@gmail.com"))
				.isEqualTo(rentalUser);
		}
		
		@Test
		public void testFindUsersByUserDetailsCallsRepoMethod() {
			RentalUsers rentalUser = getAdminRentalUser();
			UserDetails userDetails = getAdminUserDetails();
			rus.findUserByUserDetails(userDetails);
			Mockito.verify(rur, times(1)).findRentalUsersByEmail(rentalUser.getEmail());
		}
		
		
		@Test
		public void testFindUsersByUserDetailsReturnsUser() {
			RentalUsers rentalUser = getAdminRentalUser();
			UserDetails userDetails = getAdminUserDetails();
			Mockito.when(rur.findRentalUsersByEmail("naughtynas@gmail.com"))
				.thenReturn(rentalUser);
			assertThat(rus.findUserByUserDetails(userDetails))
				.isEqualTo(rentalUser);
		}
		
		@Test
		public void testFindUsersByUserDetailsNotNull() {
			assertThat(rus.findUserByUserDetails(null)).isEqualTo(null);
		}
		
		@Test
		public void testSaveCallsRepoMethod() {
			RentalUsers rentalUser = getAdminRentalUser();
			rus.save(rentalUser);
			Mockito.verify(rur, times(1)).save(rentalUser);
		}
		
		@Test
		public void testCountCallsRepoMethod() {
			rus.numUsers();
			Mockito.verify(rur, times(1)).count();
		}
		
		@Test
		public void testCountCallsReturnsLong() {
			Mockito.when(rur.count()).thenReturn(2L);
			assertThat(rus.numUsers()).isEqualTo(2L);
		}
		
}
