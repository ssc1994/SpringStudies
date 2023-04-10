package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/test/aaa")
	public String home() {
		return "home";
	}
	

}
