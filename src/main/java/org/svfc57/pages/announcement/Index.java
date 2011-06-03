package org.svfc57.pages.announcement;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.entities.Announcement;
import org.svfc57.pages.announcement.AnnouncementDetails;

@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private AnnouncementDAO<Announcement> dao;
	
	@InjectPage
	private AnnouncementDetails details;
	
	@Property
	private Announcement announcement;

	public List<Announcement> getAnnouncements() {
		return dao.getAnnouncements();
	}
	
	public Object onActionFromSelect(long announcementId) {
		details.setAnnouncementId(announcementId);

		return details;
	}
}
