package org.svfc57.components;

import nu.localhost.tapestry5.springsecurity.services.LogoutService;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;

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

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String rightColTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block rightCol;

    @Inject
    private ComponentResources resources;

	@Inject
	private LogoutService logoutService;

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
    
	@OnEvent(component = "logout")
	public void doLogout() {
		logoutService.logout();
	}
}
