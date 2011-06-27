package org.svfc57.pages.user;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.security.access.annotation.Secured;
import org.svfc57.api.UserService;
import org.svfc57.entities.User;

@Secured("ROLE_ADMIN")
public class CreateUser {

	@Property
	private User user;
	
	@InjectPage
	private Index index;
	
	@Inject
	private UserService uds;
	
	@Log
	Object onSuccess() {
		
		uds.addUser(user);
		return index;
		
	}
	
}
