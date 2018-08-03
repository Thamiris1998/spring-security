package com.example.login.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorNavegacao {
	
	@RequestMapping("/")
	public String goHome(){
		return "home";
	}
	
	@RequestMapping("/login")
	public String goLogin(){
		return "login";
	}
	
	@RequestMapping("/admin")
	public String goAdmin(){
		return "admin";
	}
}
