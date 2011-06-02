package org.svfc57.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.svfc57.entities.Person;

public class PersonDAOImpl<T> extends GenericDAOImpl<T> implements PersonDAO<T> {

	@Inject
	private Session session;
	
	@Override
	public List<Person> getPersonsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByStreet(String street) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByZip(String zip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return session.createCriteria(Person.class).list();
	}

	public Person getById(long personId) {
		return (Person) session.get(Person.class, personId);
	}
	
}
