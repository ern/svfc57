package org.svfc57.pages.person;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;

@Secured("ROLE_ADMIN")
public class CreatePerson {

	@Property
	private Person person;
	
	@Inject
	private PersonDAO<Person> dao;
	
	@InjectPage
	private Index index;
	
	public CreatePerson() {
		person = new Person();
	}
	
	@Log
	Object onSuccess() {
		dao.add(person);
		
		return index;
	}
	
}
