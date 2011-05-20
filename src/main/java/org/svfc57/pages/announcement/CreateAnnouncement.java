package org.svfc57.pages.announcement;

import java.util.Date;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.entities.Announcement;

@Secured("ROLE_ADMIN")
public class CreateAnnouncement {
	@Property
	private Announcement announcement;
	
	@Inject
	private Session session;
	
	@InjectPage
	private Index index;

	public CreateAnnouncement() {
		announcement = new Announcement();
		announcement.active = true;
		announcement.showAfterDate = new Date();
	}
	
	@Log
	@CommitAfter
	Object onSuccess() {
		session.persist(announcement);
		
		return index;
	}

}
