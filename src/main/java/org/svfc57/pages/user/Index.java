package org.svfc57.pages.user;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.UserDAO;
import org.svfc57.entities.User;

@Secured("ROLE_ADMIN")
public class Index {

	@Inject
	private UserDAO<User> dao;
	
	@Property
	private User user;
	
	@InjectPage
	private UserDetails details;

	public List<User> getUsers() {
        return dao.getUsers();
    }

	public Object onActionFromSelect(long userId) {
		details.setUserId(userId);

		return details;
	}
}