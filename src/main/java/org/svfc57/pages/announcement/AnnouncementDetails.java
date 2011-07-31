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

import org.apache.tapestry5.Asset2;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.entities.Announcement;

@Secured("ROLE_ADMIN")
public class AnnouncementDetails {

	@Property
	private Announcement announcement;

	private long announcementId;

	@Inject
	private AnnouncementDAO dao;
	
	@InjectPage
	private Index index;
	
	@Property
    @Inject
    @Path("context:layout/js/fckconfig.js")
	private Asset2 fckConfig;

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}

	public void onActivate(long announcementId) {
		this.announcementId = announcementId;
		announcement = dao.findAnnouncement(announcementId);
	}
	
	public long onPassivate() {
		return announcementId;
	}
	
	public Object onSuccess() {
		dao.update(announcement);
		
		return index;
	}
}
