package com.mmm.dsjsm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.mmm.dsjsm.dao.BaseDao;
import com.mmm.dsjsm.entity.Teacher;

@Component
public class TeacherDaoImpl extends HibernateDaoSupport implements BaseDao<Teacher, Long> {
	
	@Autowired
	public TeacherDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void create(Teacher t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public Teacher read(Long id) {
		return getHibernateTemplate().get(Teacher.class, id);
	}

	@Override
	public void update(Teacher t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Teacher t) {
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> readAll() {
		return getHibernateTemplate().find("from Teacher");
	}

}
