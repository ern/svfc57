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
