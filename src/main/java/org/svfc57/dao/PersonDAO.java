package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.Person;

public interface PersonDAO<T> extends GenericDAO<T> {
	
	public List<Person> getPersonsByLastName(String lastName);
	public List<Person> getPersonsByFirstName(String firstName);
	public List<Person> getPersonsByStreet(String street);
	public List<Person> getPersonsByZip(String zip);
	public List<Person> getPersonsByEmail(String email);
	public List<Person> getPersonsByCity(String city);
}
