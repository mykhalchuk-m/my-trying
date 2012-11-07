package com.mmm.dsjsm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.mmm.dsjsm.dao.BaseDao;
import com.mmm.dsjsm.entity.Student;

@Component
public class StudentDaoImpl extends HibernateDaoSupport implements BaseDao<Student, Long> {
	
	@Autowired
	public StudentDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void create(Student t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public Student read(Long id) {
		return getHibernateTemplate().get(Student.class, id);
	}

	@Override
	public void update(Student t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Student t) {
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> readAll() {
		return getHibernateTemplate().find("from Student");
	}


}
