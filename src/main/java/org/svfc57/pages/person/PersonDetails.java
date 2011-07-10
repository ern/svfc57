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

package org.svfc57.pages.person;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;

@Secured("ROLE_ADMIN")
public class PersonDetails {

	@Property
	private Person person;

	private long personId;

	@Inject
	private PersonDAO dao;
	
	@InjectPage
	private Index index;

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public void onActivate(long personId) {
		this.personId = personId;
		person = dao.findPerson(personId);
	}
	
	public long onPassivate() {
		return personId;
	}
	
	public Object onSuccess() {
		dao.update(person);
		
		return index;
	}
}
