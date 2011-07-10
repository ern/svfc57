/**
 * Copyright (C) 2011 Earle Nietzel <earle.nietzel@gmail.com>
 *
 * This file is part of SVFC57.
 *
 * SVFC57 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SVFC57 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SVFC57.  If not, see <http://www.gnu.org/licenses/>.
 */

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
