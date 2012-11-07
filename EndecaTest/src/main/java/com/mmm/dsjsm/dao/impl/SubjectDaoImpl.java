package com.mmm.dsjsm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.mmm.dsjsm.dao.BaseDao;
import com.mmm.dsjsm.entity.Subject;

@Component
public class SubjectDaoImpl extends HibernateDaoSupport implements BaseDao<Subject, Long> {
	
	@Autowired
	public SubjectDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void create(Subject t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public Subject read(Long id) {
		return getHibernateTemplate().get(Subject.class, id);
	}

	@Override
	public void update(Subject t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Subject t) {
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> readAll() {
		return getHibernateTemplate().find("from Subject");
	}
	
}
