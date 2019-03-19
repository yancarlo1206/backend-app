package com.tksis.backendapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addAttribute("info", "Ya ha iniciado sesión anteriormente");
			return "redirect:/";
		}
		
		return "login";
	}
	
}
