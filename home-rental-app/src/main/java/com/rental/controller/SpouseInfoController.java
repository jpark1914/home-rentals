package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.SpouseInfo;
import com.rental.service.SpouseInfoService;


@RestController 
@RequestMapping(value="/spouse")
@CrossOrigin
public class SpouseInfoController {
	
	public SpouseInfoService sis;
	@Autowired
	public SpouseInfoController(SpouseInfoService sis) {
		this.sis = sis;
	}
	
	@PostMapping("/save")
	public void saveSpouse(@RequestBody SpouseInfo spouse) {
		sis.saveSpouse(spouse);
	}

}
