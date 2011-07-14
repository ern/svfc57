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

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.api.UserService;
import org.svfc57.dao.PersonDAO;
import org.svfc57.entities.Person;
import org.svfc57.entities.User;

@Secured("ROLE_ADMIN")
public class CreateUser {

	@Property
	private User user;

	private List<Person> getPersonsWithNoUserAccount() {
		return personDao.findPersonsWithNoUserAccount();
	}
	
	@InjectPage
	private Index index;
	
	@Inject
	private UserService uds;
	
	@Inject
	private PersonDAO personDao;
	
	@Log
	Object onSuccess() {
		
		uds.addUser(user);
		return index;
		
	}
}
