package org.svfc57.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public interface GenericDAO<T> {

	@CommitAfter
	public void add(T object);
	
	@CommitAfter
	public void update(T object);

	@CommitAfter
	public void delete(T object);
}
