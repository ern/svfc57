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
