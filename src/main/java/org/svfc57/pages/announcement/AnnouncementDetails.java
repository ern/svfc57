package org.svfc57.pages.announcement;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.entities.Announcement;

public class AnnouncementDetails {

	@Property
	private Announcement announcement;

	private long announcementId;

	@Inject
	private AnnouncementDAO<Announcement> dao;
	
	@InjectPage
	private Index index;

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}

	public void onActivate(long announcementId) {
		this.announcementId = announcementId;
		announcement = dao.getById(announcementId);
	}
	
	public long onPassivate() {
		return announcementId;
	}
	
	public Object onSuccess() {
		dao.update(announcement);
		
		return index;
	}
}
