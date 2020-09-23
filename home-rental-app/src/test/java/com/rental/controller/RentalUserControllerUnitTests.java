package com.rental.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.rental.HelperMethodsForTests;
import com.rental.entity.RentalUsers;
import com.rental.service.RentalUserService;

@WebMvcTest(RentalUserController.class)
public class RentalUserControllerUnitTests {


	private MockMvc mockMvc;
	
	@Autowired
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@MockBean
	private RentalUserService rus;
	
	@MockBean
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testgetEndpoint() throws Exception {
		
		UserDetails adminUser = HelperMethodsForTests.getAdminUserDetails();
		RentalUsers adminRentalUser = HelperMethodsForTests.getAdminRentalUser();
				
		Mockito.when(rus.findUserByEmail("naughtynas@gmail.com"))
				.thenReturn(adminRentalUser);
		Mockito.when(passwordEncoder.encode("pass")).thenReturn("pass");
		
		String expectedJSON = "{\"userId\":1,\"email\":\"naughtynas@gmail.com\"," 
				+ "\"password\":\"pass\",\"isAdmin\":\"ADMIN\"}";
		
		this.mockMvc.perform(get("/user/get").with(user(adminUser)))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedJSON));
	}

}
