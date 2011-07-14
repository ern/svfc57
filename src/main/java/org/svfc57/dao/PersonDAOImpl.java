/**
 * Copyright (C) 2011 Earle Nietzel <earle.nietzel@gmail.com>
 *
 * This file is part of SVFC57.
 *
 * SVFC57 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SVFC57 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SVFC57.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.svfc57.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public Person findPerson(long personId) {
		return (Person) session.get(Person.class, personId);
	}
	
	@Override
	public List<Person> findPersonsWithNoUserAccount() {
		return session.createCriteria(Person.class).add(Restrictions.isNull("user")).list();
	}
	
}
