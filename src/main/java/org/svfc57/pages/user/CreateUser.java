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

package org.svfc57.pages.user;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.api.UserService;
import org.svfc57.dao.PersonDAO;
import org.svfc57.encoders.PersonEncoder;
import org.svfc57.encoders.PersonSelectModel;
import org.svfc57.entities.Person;
import org.svfc57.entities.User;

@Secured("PERM_ADD_USER")
public class CreateUser {

	@Property
	private User user;

	@Persist
	@Property
	private Person selectedPerson;
	
	@InjectPage
	private Index index;
	
	@Inject
	private UserService uds;
	
	@Inject
	private PersonDAO personDao;
	
	@InjectComponent
	private Zone personSelectedZone;
	
	@Inject 
	private Messages messages;

	@Inject
	private ComponentResources resources;
	
	Object onCanceled() {
		resources.discardPersistentFieldChanges();
		return index;
	}
	
	@Log
	Object onSuccess() {

		selectedPerson.setUser(user);
		user.setPerson(selectedPerson);
		// no need to call addUser as updating person will cascade to user
		personDao.update(selectedPerson);
		resources.discardPersistentFieldChanges();
		return index;
	}

	@Log
	public ValueEncoder<Person> getPersonEncoder() {
		return new PersonEncoder(personDao);
	}

	@Log
	public SelectModel getPersonSelectModel() {
		return new PersonSelectModel(personDao.findPersonsWithNoUserAccount());
	}
	
	@Log
	Object onValueChangedFromPersonSelection(Person person) {
		//selectedPerson = personDao.findPerson(Long.parseLong(personId));
		selectedPerson = person;
		return personSelectedZone.getBody();
	}
}
