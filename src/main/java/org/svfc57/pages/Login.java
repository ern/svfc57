package org.svfc57.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Value;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.annotations.Log;

public class Login {
	@Inject
	@Value("${spring-security.check.url}")
	private String checkUrl;

	@Inject
	private Request request;

	private boolean failed = false;

	public boolean isFailed() {
		return failed;
	}

	public String getLoginCheckUrl() {
		return request.getContextPath() + checkUrl;
	}

	@Log
	public void onActivate(String extra) {
		if (extra.equals("failed")) {
			failed = true;
		}
	}
}
