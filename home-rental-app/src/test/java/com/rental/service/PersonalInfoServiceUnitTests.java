package com.rental.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rental.HelperMethodsForTests;
import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;
import com.rental.repo.PersonalInfoRepo;
import com.rental.repo.RentalUserRepo;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PersonalInfoServiceUnitTests {

		@Mock
		private PersonalInfoRepo pir;
		
		@Mock
		private RentalUserRepo rur;
		
		@InjectMocks
		private PersonalInfoService pis;
		
		@Test
		public void testGetPersonalInfoCallsRepoMethod() {
			RentalUsers rentalUser = HelperMethodsForTests.getAdminRentalUser();
			pis.getPersonalInfo(rentalUser);
			Mockito.verify(pir, Mockito.times(1)).findPersonalInfoOfUser(rentalUser.getUserId());
		}
		
		@Test
		public void testGetPersonalInfoReturnsOptionalNotNull() {
			RentalUsers rentalUser = HelperMethodsForTests.getAdminRentalUser();
			PersonalInfo personalInfo = HelperMethodsForTests.getAdminPersonalInfo();
			Mockito.when(pir.findPersonalInfoOfUser(rentalUser.getUserId())).thenReturn(personalInfo);
			assertThat(pis.getPersonalInfo(rentalUser)).isExactlyInstanceOf(Optional.class);
			assertThat(pis.getPersonalInfo(rentalUser).get()).isEqualTo(personalInfo);
		}
		
		@Test
		public void testGetPersonalInfoReturnsOptionalNull() {
			RentalUsers rentalUser = HelperMethodsForTests.getAdminRentalUser();
			Mockito.when(pir.findPersonalInfoOfUser(rentalUser.getUserId())).thenReturn(null);
			assertThat(pis.getPersonalInfo(rentalUser)).isExactlyInstanceOf(Optional.class);
			assertThat(pis.getPersonalInfo(rentalUser).isPresent()).isEqualTo(false);
		}
		
		@Test
		public void testSavePersonalInfoCallsRepoMethod() {
			RentalUsers rentalUser = HelperMethodsForTests.getAdminRentalUser();
			PersonalInfo personalInfo = HelperMethodsForTests.getAdminPersonalInfo();
			pis.savePersonalInfo(personalInfo, rentalUser);
			Mockito.verify(pir, Mockito.times(1)).save(personalInfo);
		}
 		
		
}
