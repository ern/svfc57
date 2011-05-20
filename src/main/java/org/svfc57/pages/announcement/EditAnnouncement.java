package org.svfc57.pages.announcement;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.entities.Announcement;

@Secured("ROLE_ADMIN")
public class EditAnnouncement {

	@Inject
	private Session session;
	
	private Announcement announcement;

	private long announcementId;

	void onActivate(long announcementId) {
		this.announcementId = announcementId;

		announcement = (Announcement) session.createCriteria(Announcement.class).add(Restrictions.idEq(announcementId));
	}

	long onPassivate() {
		return announcementId;
	}
	
/*	@Inject
	private Session session;

	public List<Announcement> getAnnouncements() {
        return session.createCriteria(Announcement.class).list();
    }
*/
}
