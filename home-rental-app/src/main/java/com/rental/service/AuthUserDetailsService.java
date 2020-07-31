package com.rental.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental.authority.AdminAuthority;
import com.rental.authority.UserAuthority;
import com.rental.entity.RentalUsers;
import com.rental.repo.RentalUserRepo;

@Service
public class AuthUserDetailsService implements UserDetailsService {
	
	
	private RentalUserRepo userRepo;
	
	@Autowired
	public void setUserRepo(RentalUserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		RentalUsers user = userRepo.findRentalUsersByEmail(email);
		
		 ArrayList<GrantedAuthority> roles = new ArrayList<>();
		 roles.add(new UserAuthority());
		 
		 if (user == null) {
	            throw new UsernameNotFoundException(email);
	        } 
		 
<<<<<<< HEAD:home-rental-app/src/main/java/com/rental/service/JwtUserDetailsService.java
		 if (user.getIsAdmin() != null) {
			 if(user.getIsAdmin().equals("ADMIN")) {
				 roles.add(new AdminAuthority());
			 }
=======
		 if(user.getIsAdmin() != null && user.getIsAdmin().equals("ADMIN")) {
			 roles.add(new AdminAuthority());
>>>>>>> 68fe88b2f960511ed900388c506748623480f598:home-rental-app/src/main/java/com/rental/service/AuthUserDetailsService.java
		 }
		 
		return new User(user.getEmail(),user.getPassword(),roles);
		//return new User("test@example.com","password", new ArrayList<>());
	}
	
}