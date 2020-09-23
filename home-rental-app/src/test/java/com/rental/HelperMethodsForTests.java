package com.rental;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.rental.authority.AdminAuthority;
import com.rental.authority.UserAuthority;
import com.rental.entity.PersonalInfo;
import com.rental.entity.RentalUsers;

public class HelperMethodsForTests {

	
	public static UserDetails getAdminUserDetails() {
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new UserAuthority());
		roles.add(new AdminAuthority());
		return new User("naughtynas@gmail.com", "pass", roles);
	}
	
	public static RentalUsers getAdminRentalUser() {
		return new RentalUsers(1L,"naughtynas@gmail.com","pass","ADMIN");
	}
	
	public static PersonalInfo getAdminPersonalInfo() {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setPersonId(1);
		personalInfo.setFirstName("Naughty");
		personalInfo.setLastName("Nas");
		personalInfo.setPhoneNumber(8321L);
		personalInfo.setDateOfBirth("28-03-1993");
		personalInfo.setDriverLicense("234eds9023");
		personalInfo.setSsn(99110022L);
		personalInfo.setAddress("31 Exampletown");
		personalInfo.setCity("Example City");
		personalInfo.setState("Example State");
		personalInfo.setZip(11233);
		personalInfo.setTimeAtPresentAddr(1);
		personalInfo.setLandlord("Mr. Landlord");
		personalInfo.setLandlordPhone(908763L);
		personalInfo.setContactPersonFirstName("Contact");
		personalInfo.setContactPersonLastName("Person");
		personalInfo.setContactPersonPhone(89023L);
		personalInfo.setEmployer("Employer");
		personalInfo.setOccupation("Software Engineer");
		personalInfo.setCurrentSalary(42000D);
		personalInfo.setTimeEmployed(1);
		personalInfo.setUserId(1L);
		return personalInfo;
		
	}
}
