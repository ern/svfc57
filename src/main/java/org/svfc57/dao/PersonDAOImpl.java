package org.svfc57.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.svfc57.entities.Person;

public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

	@Inject
	private Session session;
	
	@Override
	public List<Person> findPersonsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersonsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersonsByStreet(String street) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersonsByZip(String zip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersonsByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersonsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findPersons() {
		// TODO Auto-generated method stub
		return session.createCriteria(Person.class).list();
	}

	public Person findPerson(long personId) {
		return (Person) session.get(Person.class, personId);
	}
	
}
