package com.rental.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.rental.authority.AdminAuthority;
import com.rental.authority.UserAuthority;
import com.rental.entity.RentalUsers;
import com.rental.service.RentalUserService;

@WebMvcTest(RentalUserController.class)
public class RentalUserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RentalUserService rus;
	
	@MockBean
	private PasswordEncoder passwordEncoder;

	private UserDetails adminUserDetails;
	private RentalUsers adminRentalUser;
	
	public void setUpAdminUser() {
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new UserAuthority());
		roles.add(new AdminAuthority());
		this.adminUserDetails = new User("naughtynas@gmail.com", "pass", roles);
		this.adminRentalUser = new RentalUsers(1L,"naughtynas@gmail.com","pass","ADMIN");
	}
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {

		this.setUpAdminUser();
		
		Mockito.when(rus.findUserByEmail("naughtynas@gmail.com"))
			.thenReturn(this.adminRentalUser);
		
		Mockito.when(passwordEncoder.encode("pass")).thenReturn("pass");
		
		this.mockMvc
			.perform(get("/user/get").with(user(this.adminUserDetails)))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"userId\":1,\"email\":\"naughtynas@gmail.com\",\"password\":\"pass\",\"isAdmin\":\"ADMIN\"}"));
	}

}
