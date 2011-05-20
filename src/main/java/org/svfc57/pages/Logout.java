package org.svfc57.pages;

import nu.localhost.tapestry5.springsecurity.services.LogoutService;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Logout {

	@Inject
	private LogoutService logoutService;

	@Log
    boolean beginRender( MarkupWriter writer ) throws Exception {

		logoutService.logout();
		return true;
    }
	/*@Log
	@OnEvent(component = "logout")
	public void doLogout() {
    	// logoutService.logout();
    	// Redirect to a page to safely logout
    	
	}*/

}
