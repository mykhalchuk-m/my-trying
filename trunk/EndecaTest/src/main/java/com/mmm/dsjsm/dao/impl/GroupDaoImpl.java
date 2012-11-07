package com.mmm.dsjsm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.mmm.dsjsm.dao.BaseDao;
import com.mmm.dsjsm.entity.Group;

@Component
public class GroupDaoImpl extends HibernateDaoSupport implements BaseDao<Group, Long> {

	@Autowired
	public GroupDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void create(Group t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public Group read(Long id) {
		return getHibernateTemplate().get(Group.class, id);
	}

	@Override
	public void update(Group t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Group t) {
		getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> readAll() {
		return getHibernateTemplate().find("from Group");
	}
}
