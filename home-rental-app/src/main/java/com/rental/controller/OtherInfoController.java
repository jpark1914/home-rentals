package com.rental.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.OtherInfo;
import com.rental.service.OtherInfoService;
import com.rental.service.RentalUserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/other")
public class OtherInfoController {
	
	private OtherInfoService ois;
	private RentalUserService rus;
	
	@Autowired
	public OtherInfoController(OtherInfoService ois, RentalUserService rus) {
		this.ois = ois;
		this.rus = rus;
	}
	
	@PostMapping(value = "/save")
	public String saveOtherInfo(@RequestBody OtherInfo otherInfo) {
		return ois.saveOtherInfo(otherInfo);
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<OtherInfo> getOtherInfo(@AuthenticationPrincipal UserDetails user) {
		long userId = rus.findUserByEmail(user.getUsername()).getUserId();
		Optional<OtherInfo> opOther = ois.getOtherInfo(userId);
		if (opOther.isPresent()) {
			return ResponseEntity.ok(opOther.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
