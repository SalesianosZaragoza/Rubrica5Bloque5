package com.kerjox.rubrica5bloque5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControleler {

	@GetMapping("/")
	public String index() {

		return "index";
	}
}
