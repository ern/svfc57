package org.svfc57.pages.announcement;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.entities.Announcement;

@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private Session session;

	public List<Announcement> getAnnouncements() {
        return session.createCriteria(Announcement.class).list();
    }
}
