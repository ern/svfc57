package org.svfc57.dao;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.svfc57.entities.Announcement;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	@Inject
	private Session session;

	@Override
	public void create(T object) {
		// TODO Auto-generated method stub
		session.save(object);
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		session.update(object);
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

}
