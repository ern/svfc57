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
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.api.UserService;
import org.svfc57.entities.User;
import org.svfc57.model.Role;

@Secured("ROLE_ADMIN")
public class UserDetails {

	@Property
	private User user;

	private long userId;

	@InjectPage
	private Index index;
	
	@Inject 
	private UserService uds;
	
	@Inject 
	private Messages messages;
	
	@Inject
	private ComponentResources resources;
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void onActivate(long userId) {
		this.userId = userId;
		user = uds.findUser(userId);
		user.setPassword("");
	}
	
	public long onPassivate() {
		return userId;
	}
	
	public Object onSuccess() {
		uds.updateUser(user);
		resources.discardPersistentFieldChanges();
		return index;
	}
	
	Object onCanceled() {
		resources.discardPersistentFieldChanges();
		return index;
	}
	
	public SelectModel getRoles() {
		return new EnumSelectModel(Role.class, messages);
	}
}
