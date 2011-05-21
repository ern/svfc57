package org.svfc57.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.svfc57.entities.Announcement;

public class AnnouncementDAOImpl implements AnnouncementDAO {
		
	@Inject
	private Session session;

	@SuppressWarnings("unchecked")
	public List<Announcement> getAnnouncements() {
        return (List<Announcement>) session.createCriteria(Announcement.class).list();
    }

	public Announcement getById(long announcementId) {
		return (Announcement) session.get(Announcement.class, announcementId);
	}

}
