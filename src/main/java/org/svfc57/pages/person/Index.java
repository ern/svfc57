package org.svfc57.pages.person;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;

@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private PersonDAO dao;
	
	@Property
	private Person person;
	
	@InjectPage
	private PersonDetails details;

	public List<Person> getPersons() {
        return dao.getPersons();
    }

	public Object onActionFromSelect(long personId) {
		details.setPersonId(personId);

		return details;
	}
}
