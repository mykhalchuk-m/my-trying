package com.mmm.spring.socsec.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmm.spring.socsec.entity.User;
import com.mmm.spring.socsec.service.UserService;

@Repository
public class UserServiseImpl implements UserService {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUserById(String userId) {
		User user = (User) sessionFactory.openSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) sessionFactory.openSession()
				.createCriteria(User.class).list();
	}

	public String getUserProvider(String userId) {
		User user = (User) sessionFactory.openSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
		return user.getProviderId();

	}

}
