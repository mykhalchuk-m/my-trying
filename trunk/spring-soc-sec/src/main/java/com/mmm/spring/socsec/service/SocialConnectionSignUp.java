package com.mmm.spring.socsec.service;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

public class SocialConnectionSignUp implements ConnectionSignUp {

	public String execute(Connection<?> connection) {
		return connection.getDisplayName();
	}

}
