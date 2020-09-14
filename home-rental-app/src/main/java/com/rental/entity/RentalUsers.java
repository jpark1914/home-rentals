package com.rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="RENTAL_USERS")
@Getter @Setter @NoArgsConstructor
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
	
}
