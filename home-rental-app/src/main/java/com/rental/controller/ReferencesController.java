package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entity.References;
import com.rental.service.ReferencesService;

@RestController
@CrossOrigin
@RequestMapping(value = "/references")
public class ReferencesController {

	private ReferencesService refS;
	
	@Autowired
	public void setrefS(ReferencesService refS) {
		this.refS = refS;
	}
	
	@PostMapping(value = "/save")
	public String saveRefs(@RequestBody References reference) {
		return refS.saveRef(reference);
	}
}
