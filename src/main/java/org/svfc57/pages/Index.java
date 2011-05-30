package org.svfc57.pages;

import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.entities.Announcement;

/**
 * Start page of application svfc57.
 */
public class Index {
	
	@Inject
	private AnnouncementDAO dao;

	@Property
	private Announcement announcement;

	public List<Announcement> getCurrentActiveAnnouncements() {
		return dao.getCurrentActiveAnnouncements();
	}

	public Date getCurrentTime() {
		return new Date();
	}

}
