package org.svfc57.pages.person;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;

public class PersonDetails {

	@Property
	private Person person;

	private long personId;

	@Inject
	private PersonDAO dao;

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public void onActivate(long personId) {
		this.personId = personId;
		person = dao.getById(personId);
	}
	
	public long onPassivate() {
		return personId;
	}
}
