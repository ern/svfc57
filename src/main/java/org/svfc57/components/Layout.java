package org.svfc57.components;

import nu.localhost.tapestry5.springsecurity.services.LogoutService;

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
    
    @Log
	@OnEvent(component = "logout")
	public void doLogout() {
		logoutService.logout();
	}
    
    boolean beginRender( MarkupWriter writer ) throws Exception {

        currentUser = SecurityContextHolder.getContext().getAuthentication();

        if ( null != currentUser ) {
            userName = currentUser.getName();
        }
        return true;
    }
}
