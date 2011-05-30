package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.Announcement;

public interface AnnouncementDAO {
	
	public List<Announcement> getAnnouncements();
	
	public Announcement getById(long announcementId);
	
	public List<Announcement> getCurrentActiveAnnouncements();
	
}
