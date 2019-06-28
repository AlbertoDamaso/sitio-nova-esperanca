package com.sitio.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("usuario/entrada")
	public String entrada() {
		return "usuario/entrada";
	}
	
	@GetMapping("usuario/menu")
	public String menu() {
		return "usuario/menu";
	}
}
