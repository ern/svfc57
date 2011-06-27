package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.Announcement;

public interface AnnouncementDAO extends GenericDAO<Announcement> {
	
	public List<Announcement> findAllAnnouncements();
	public Announcement findAnnouncement(long announcementId);
	public List<Announcement> findCurrentActiveAnnouncements();
}
