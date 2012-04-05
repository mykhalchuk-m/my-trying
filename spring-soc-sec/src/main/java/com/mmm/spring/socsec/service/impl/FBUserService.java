package com.mmm.spring.socsec.service.impl;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;

import com.mmm.spring.socsec.service.SocUserService;

public class FBUserService implements SocUserService {

	private Facebook facebook;

	public String getPicure() {
		return "http://graph.facebook.com/"
				+ facebook.userOperations().getUserProfile().getId()
				+ "/picture";
	}

	public String getName() {
		return facebook.userOperations().getUserProfile().getFirstName();
	}

	public void setConnectionRepository(
			ConnectionRepository connectionRepository) {
		Connection<Facebook> connection = connectionRepository
				.getPrimaryConnection(Facebook.class);
		facebook = connection.getApi();
	}

}
