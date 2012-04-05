package com.mmm.spring.socsec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.connect.ConnectionRepository;

import com.mmm.spring.socsec.service.impl.FBUserService;
import com.mmm.spring.socsec.service.impl.TVUserService;
import com.mmm.spring.socsec.service.impl.VKUserService;

public class UserServiceFactory {
	private static Map<SocialSet, SocUserService> map = new HashMap<SocialSet, SocUserService>();
	
	static {
		map.put(SocialSet.facebook, new FBUserService());
		map.put(SocialSet.twitter, new TVUserService());
		map.put(SocialSet.vkontakte, new VKUserService());
	}
	
	public static SocUserService getSocUserService(String provider, ConnectionRepository connectionRepository) {
		if (provider == null)
			throw new NullPointerException("unkniwn provider name");
		
		SocUserService sus = map.get(SocialSet.valueOf(provider));
		if (sus == null) 
			throw new NullPointerException("connt get user service with name: " + provider);
		
		sus.setConnectionRepository(connectionRepository);
		return sus;
	}
}
