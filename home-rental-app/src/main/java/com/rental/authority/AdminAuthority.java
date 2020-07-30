package com.rental.authority;

import org.springframework.security.core.GrantedAuthority;

public class AdminAuthority implements GrantedAuthority {

	@Override
	public String getAuthority() {
		return "ADMIN";
	}

}
