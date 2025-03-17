package com.questk2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController<Model> {
	@GetMapping("/")
	public String display(Model model) {
		((org.springframework.ui.Model) model).addAttribute("message", "My first Program...");
		return "index";
	}
}
