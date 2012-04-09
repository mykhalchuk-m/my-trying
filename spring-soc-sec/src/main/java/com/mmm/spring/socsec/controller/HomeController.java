package com.mmm.spring.socsec.controller;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmm.spring.socsec.service.SocUserService;
import com.mmm.spring.socsec.service.UserService;
import com.mmm.spring.socsec.service.UserServiceFactory;

@Controller
public class HomeController {

	@Inject
	private UserService userService;

	@Inject
	private ConnectionRepository connectionRepository;

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/signin")
	public String signin() {
		return "index";
	}

	@RequestMapping(value = "soc", method = RequestMethod.GET)
	public String soc(Model model) {

		String provider = userService.getUserProvider(SecurityContextHolder
				.getContext().getAuthentication().getName());
		SocUserService sus =  UserServiceFactory.getSocUserService(provider, connectionRepository);
		model.addAttribute("name", sus.getName());
		model.addAttribute("photo", sus.getPicure());
		return "soc";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public String updateStatus(@RequestParam String message, Model model) {
		String provider = userService.getUserProvider(SecurityContextHolder
				.getContext().getAuthentication().getName());
		SocUserService sus =  UserServiceFactory.getSocUserService(provider, connectionRepository);
		sus.postToWall(message);
		return "redirect:soc";
	}

}
