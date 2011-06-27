package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.Person;

public interface PersonDAO extends GenericDAO<Person> {
	
	public List<Person> findPersonsByLastName(String lastName);
	public List<Person> findPersonsByFirstName(String firstName);
	public List<Person> findPersonsByStreet(String street);
	public List<Person> findPersonsByZip(String zip);
	public List<Person> findPersonsByEmail(String email);
	public List<Person> findPersonsByCity(String city);
	public List<Person> findPersons();
	public Person findPerson(long personId);
}
