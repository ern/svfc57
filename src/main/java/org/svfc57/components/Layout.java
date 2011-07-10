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

package org.svfc57.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Layout component for pages of application svfc57.
 */
@Import(stylesheet="context:layout/layout.css")
public class Layout
{
    /** The page title, for the <title> element and the <h1> element. */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;
    
    private Authentication currentUser;
    
    @Property
    private String userName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String rightColTitle;

    @Inject
    private ComponentResources resources;
	
    public String getClassForPageName()
    {
      return resources.getPageName().equalsIgnoreCase(pageName)
             ? "current_page_item"
             : null;
    }

    public String[] getPageNames()
    {
      return new String[] { "Apparatus", "About", "Contact" };
    }

    /*@Log
	@OnEvent(component = "logout")
	public void doLogout() {
    	// logoutService.logout();
    	// Redirect to a page to safely logout
    	
	}*/
    
    boolean beginRender( MarkupWriter writer ) throws Exception {

        currentUser = SecurityContextHolder.getContext().getAuthentication();

        if ( null != currentUser ) {
            userName = currentUser.getName();
        }
        return true;
    }
}
