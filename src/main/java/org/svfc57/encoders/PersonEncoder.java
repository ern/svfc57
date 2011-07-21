package org.svfc57.encoders;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;

public class PersonEncoder implements ValueEncoder<Person> {

	private PersonDAO dao;

	public PersonEncoder(PersonDAO personDao) {
		// TODO Auto-generated constructor stub
		this.dao = personDao;
	}

	@Log
	@Override
	public String toClient(Person person) {
		return String.valueOf(person.id);
	}

	@Log
	@Override
	public Person toValue(String id) {
		if(dao != null)
			return dao.findPerson(Long.parseLong(id));
		else
			return null;
	}

}
