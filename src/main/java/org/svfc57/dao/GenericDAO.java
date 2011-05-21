package org.svfc57.dao;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public interface GenericDAO {

	@CommitAfter
	public void add(Object object);
	
	@CommitAfter
	public void update(Object object);

	@CommitAfter
	public void delete(Object object);
}
