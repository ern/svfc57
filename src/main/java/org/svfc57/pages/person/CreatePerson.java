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
	private PersonDAO dao;
	
	@InjectPage
	private Index index;
	
	@Log
	Object onSuccess() {
		dao.create(person);
		
		return index;
	}
	
}
