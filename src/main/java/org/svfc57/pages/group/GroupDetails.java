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

package org.svfc57.pages.group;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;

@Secured("PERM_UPDT_GROUP")
public class GroupDetails {

	private long groupId;
	
	@InjectPage
	private Index index;
	
	@Inject 
	private Messages messages;
	
	@Inject
	private ComponentResources resources;
	
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public void onActivate(long groupId) {
		this.groupId = groupId;
		/*user = uds.findUser(userId);*/
	}
	
	public long onPassivate() {
		return groupId;
	}
	
	public Object onSuccess() {
/*		uds.updateUser(user);*/
		resources.discardPersistentFieldChanges();
		return index;
	}
	
	Object onCanceled() {
		resources.discardPersistentFieldChanges();
		return index;
	}
}
