package org.svfc57.pages.person;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.springframework.security.annotation.Secured;
import org.svfc57.entities.Person;

//@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private Session session;

	public List<Person> getPersons() {
        return session.createCriteria(Person.class).list();
    }

}
