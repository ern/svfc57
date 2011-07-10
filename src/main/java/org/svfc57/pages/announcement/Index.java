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

package org.svfc57.pages.announcement;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.entities.Announcement;
import org.svfc57.pages.announcement.AnnouncementDetails;

@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private AnnouncementDAO dao;
	
	@InjectPage
	private AnnouncementDetails details;
	
	@Property
	private Announcement announcement;

	public List<Announcement> getAnnouncements() {
		return dao.findAllAnnouncements();
	}
	
	public Object onActionFromSelect(long announcementId) {
		details.setAnnouncementId(announcementId);

		return details;
	}
}
