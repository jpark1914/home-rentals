package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.OtherInfo;
import com.rental.service.OtherInfoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/otherInfo")
public class OtherInfoController {
	
	private OtherInfoService ois;
	
	@Autowired
	public OtherInfoController(OtherInfoService ois) {
		this.ois = ois;
	}
	
	@PostMapping(value = "/save")
	public String saveOtherInfo(@RequestBody OtherInfo otherInfo) {
		return ois.saveOtherInfo(otherInfo);
	}
}
