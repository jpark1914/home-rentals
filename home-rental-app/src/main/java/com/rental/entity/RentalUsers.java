package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RENTAL_USERS")
public class RentalUsers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_SEQ")
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="EMAIL", unique = true)
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="IS_ADMIN")
	private String isAdmin;
	
	public RentalUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RentalUsers( String email, String password, String isAdmin) {
		super();
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "RentalUsers [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
