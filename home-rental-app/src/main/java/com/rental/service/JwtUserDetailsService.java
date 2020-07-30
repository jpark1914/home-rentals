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
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RentalUserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		RentalUsers user = userRepo.findRentalUsersByEmail(email);
		
		 ArrayList<GrantedAuthority> roles = new ArrayList<>();
		 roles.add(new UserAuthority());
		 
		 if (user == null) {
	            throw new UsernameNotFoundException(email);
	        }
		 
		 if(user.getIsAdmin().equals("ADMIN")) {
			 roles.add(new AdminAuthority());
		 }
		
		return new User(user.getEmail(),user.getPassword(),roles);
	}
	
}