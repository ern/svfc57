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
import org.svfc57.entities.Announcement;

public class AnnouncementDAOImpl extends GenericDAOImpl<Announcement> implements AnnouncementDAO {
		
	@Inject
	private Session session;

	@SuppressWarnings("unchecked")
	public List<Announcement> findAllAnnouncements() {
        return (List<Announcement>) session.createCriteria(Announcement.class).list();
    }

	public Announcement findAnnouncement(long announcementId) {
		return (Announcement) session.get(Announcement.class, announcementId);
	}
	
	public List<Announcement> findCurrentActiveAnnouncements() {
		// TODO restrict to only active announcements
		return (List<Announcement>) session.createCriteria(Announcement.class).list();
	}
}
