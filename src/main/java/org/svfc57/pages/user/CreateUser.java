package org.svfc57.pages.user;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.dao.UserDAO;
import org.svfc57.entities.User;

@Secured("ROLE_ADMIN")
public class CreateUser {

	@Property
	private User user;
	
	@Inject
	private UserDAO<User> dao;
	
	@InjectPage
	private Index index;
	
	public CreateUser() {
		user = new User();
	}
	
	@Log
	Object onSuccess() {
		dao.add(user);
		
		return index;
	}
	
}
