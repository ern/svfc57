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
