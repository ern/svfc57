package org.svfc57.pages.person;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.svfc57.entities.Person;

public class CreatePerson {

	@Property
	private Person person;
	
	@Inject
	private Session session;
	
	@InjectPage
	private Index index;
	
	@Log
	@CommitAfter
	Object onSuccess() {
		session.persist(person);
		
		return index;
	}
	
}
