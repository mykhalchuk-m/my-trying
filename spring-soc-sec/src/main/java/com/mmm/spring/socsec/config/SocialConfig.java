package com.mmm.spring.socsec.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.social.vkontakte.connect.VKontakteConnectionFactory;

import com.mmm.spring.socsec.service.SocialConnectionSignUp;
import com.mmm.spring.socsec.service.SocialSignInAdapter;

@Configuration
public class SocialConfig {
	@Inject
	private DataSource dataSource;

	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(
				"261893670554548", "2d1394200d2283b9af775813c5abb5f7"));
		registry.addConnectionFactory(new TwitterConnectionFactory(
				"YR571S2JiVBOFyJS5MEg",
				"Kb8hS0luftwCJX3qVoyiLUMfZDtK1EozFoUkjNLUMx4"));
		registry.addConnectionFactory(new VKontakteConnectionFactory(
				"2862609", "YiAnAYlXDS1FSOIi3dTG"));
		return registry;
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
				dataSource, connectionFactoryLocator(), Encryptors.noOpText());
		repository.setConnectionSignUp(new SocialConnectionSignUp());
		return repository;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return usersConnectionRepository().createConnectionRepository(
				authentication.getName());
	}

	@Bean
	public ProviderSignInController signInController() {
		return new ProviderSignInController(connectionFactoryLocator(),
				usersConnectionRepository(), new SocialSignInAdapter());
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Facebook facebook() {
		return connectionRepository().findPrimaryConnection(Facebook.class)
				.getApi();
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Twitter twitter() {
		return connectionRepository().findPrimaryConnection(Twitter.class)
				.getApi();
	}
	
	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public VKontakte vKontakte() {
		return connectionRepository().findPrimaryConnection(VKontakte.class)
				.getApi();
	}
}
