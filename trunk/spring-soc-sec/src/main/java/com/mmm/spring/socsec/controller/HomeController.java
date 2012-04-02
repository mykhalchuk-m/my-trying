package com.mmm.spring.socsec.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmm.spring.socsec.entity.User;
import com.mmm.spring.socsec.service.UserService;

@Controller
public class HomeController {
	
	@Inject
	private UserService userService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/soclogin")
	public String soclogin() {
		return "login-soc";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		return "facebook";
	}
	
}
