package org.svfc57.pages.user;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.UserDAO;
import org.svfc57.entities.User;

@Secured("ROLE_ADMIN")
public class UserDetails {

	@Property
	private User user;

	private long userId;

	@Inject
	private UserDAO<User> dao;
	
	@InjectPage
	private Index index;

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void onActivate(long userId) {
		this.userId = userId;
		user = dao.getUserById(userId);
	}
	
	public long onPassivate() {
		return userId;
	}
	
	public Object onSuccess() {
		dao.update(user);
		
		return index;
	}
}
