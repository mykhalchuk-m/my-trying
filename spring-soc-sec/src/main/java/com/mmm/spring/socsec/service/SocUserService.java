package com.mmm.spring.socsec.service;

import org.springframework.social.connect.ConnectionRepository;

public interface SocUserService {
	String getPicure();

	String getName();
	
	void setConnectionRepository(ConnectionRepository connectionRepository);
}
