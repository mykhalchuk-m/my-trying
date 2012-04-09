package com.mmm.spring.socsec.service.impl;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

import com.mmm.spring.socsec.service.SocUserService;

public class TVUserService implements SocUserService {

	private Twitter twitter;

	public String getPicure() {
		return twitter.userOperations().getUserProfile().getProfileImageUrl();
	}

	public String getName() {
		return twitter.userOperations().getScreenName();
	}

	public void setConnectionRepository(
			ConnectionRepository connectionRepository) {
		Connection<Twitter> connection = connectionRepository
				.getPrimaryConnection(Twitter.class);
		twitter = connection.getApi();

	}

	public void postToWall(String message) {
		twitter.timelineOperations().updateStatus(message);
	}

}
