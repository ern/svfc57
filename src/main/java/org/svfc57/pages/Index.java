package org.svfc57.pages;

import java.util.Date;

import nu.localhost.tapestry5.springsecurity.services.LogoutService;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Start page of application svfc57.
 */
public class Index {

	public Date getCurrentTime() {
		return new Date();
	}

}
