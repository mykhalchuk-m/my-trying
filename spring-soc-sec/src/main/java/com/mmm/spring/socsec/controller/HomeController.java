package com.mmm.spring.socsec.controller;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Inject
	private Facebook facebook;
	@Inject
	private Twitter twitter;
	@Inject
	private VKontakte vKontakte;

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
		
		model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
		
//		if (facebook != null)
//			if (facebook.isAuthorized()) {
//				model.addAttribute("fUser", facebook.userOperations()
//						.getUserProfile().getFirstName());
//				model.addAttribute("fPhoto", "http://graph.facebook.com/"
//						+ facebook.userOperations().getUserProfile().getId()
//						+ "/picture");
//			}
//		if (twitter != null)
//			if (twitter.isAuthorized()) {
//				model.addAttribute("tUser", twitter.userOperations()
//						.getScreenName());
//				model.addAttribute("tPhoto", twitter.userOperations()
//						.getUserProfile().getProfileImageUrl());
//			}
//		if (vKontakte != null)
//			if (vKontakte.isAuthorized()) {
//				model.addAttribute("vUser", vKontakte.usersOperations()
//						.getProfile().getFirstName());
//				model.addAttribute("vPhoto", vKontakte.usersOperations()
//						.getProfile().getPhoto());
//			}
		return "soc";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/soclogin")
	public String soclogin() {
		return "login-soc";
	}
	
	

}
