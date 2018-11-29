package com.lcsolution.smartIntegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {
	
	@GetMapping(value="/hello")
	public String test() {
		return "Hello World";
	}
	
	

}
