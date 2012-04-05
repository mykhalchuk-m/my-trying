package com.mmm.spring.socsec.service.impl;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.vkontakte.api.VKontakte;

import com.mmm.spring.socsec.service.SocUserService;

public class VKUserService implements SocUserService {

	private VKontakte vKontakte;

	public String getPicure() {
		return vKontakte.usersOperations().getProfile().getPhoto();
	}

	public String getName() {
		return vKontakte.usersOperations().getProfile().getFirstName();
	}

	public void setConnectionRepository(
			ConnectionRepository connectionRepository) {
		Connection<VKontakte> connection = connectionRepository
				.getPrimaryConnection(VKontakte.class);
		vKontakte = connection.getApi();
	}

}
