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

package org.svfc57.services;

import java.io.IOException;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.services.AliasContribution;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.svfc57.api.UserService;
import org.svfc57.dao.AnnouncementDAO;
import org.svfc57.dao.AnnouncementDAOImpl;
import org.svfc57.dao.PersonDAO;
import org.svfc57.dao.PersonDAOImpl;
import org.svfc57.dao.UserDAO;
import org.svfc57.dao.UserDAOImpl;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AppModule
{
    public static void bind(ServiceBinder binder)
    {
        // binder.bind(MyServiceInterface.class, MyServiceImpl.class);
        
        // Make bind() calls on the binder object to define most IoC services.
        // Use service builder methods (example below) when the implementation
        // is provided inline, or requires more initialization than simply
        // invoking the constructor.
    	
    	binder.bind(UserService.class, UserServiceImpl.class);
    	binder.bind(AnnouncementDAO.class, AnnouncementDAOImpl.class);
    	binder.bind(PersonDAO.class, PersonDAOImpl.class);
    	binder.bind(UserDAO.class, UserDAOImpl.class);
    }
    
	@Match("*DAO")
	public static void adviseTransactions(HibernateTransactionAdvisor advisor,
			MethodAdviceReceiver receiver) {
		advisor.addTransactionCommitAdvice(receiver);
	}
    
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, String> configuration)
    {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
        
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");

        // The factory default is true but during the early stages of an application
        // overriding to false is a good idea. In addition, this is often overridden
        // on the command line as -Dtapestry.production-mode=false
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");

        // The application version number is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version number should also
        // change, to force the browser to download new versions.
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
        
		configuration.add("tapestry.default-cookie-max-age", "31536000");

		configuration.add("spring-security.failure.url", "/login/failed");
		configuration.add("spring-security.accessDenied.url", "/forbidden");
		configuration.add("spring-security.check.url", "/j_spring_security_check");
		configuration.add("spring-security.target.url", "/");
		configuration.add("spring-security.afterlogout.url", "/");
		configuration.add("spring-security.rememberme.key", "REMEMBERMEKEY");
		configuration.add("spring-security.loginform.url", "/login");
		configuration.add("spring-security.force.ssl.login", "false");
		configuration.add("spring-security.anonymous.key", "acegi_anonymous");
		configuration.add("spring-security.anonymous.attribute", "anonymous,ROLE_ANONYMOUS");
		configuration.add("spring-security.password.salt", "DEADBEEF");
    }
    

    /**
     * This is a service definition, the service will be named "TimingFilter". The interface,
     * RequestFilter, is used within the RequestHandler service pipeline, which is built from the
     * RequestHandler service configuration. Tapestry IoC is responsible for passing in an
     * appropriate Logger instance. Requests for static resources are handled at a higher level, so
     * this filter will only be invoked for Tapestry related requests.
     * 
     * <p>
     * Service builder methods are useful when the implementation is inline as an inner class
     * (as here) or require some other kind of special initialization. In most cases,
     * use the static bind() method instead. 
     * 
     * <p>
     * If this method was named "build", then the service id would be taken from the 
     * service interface and would be "RequestFilter".  Since Tapestry already defines
     * a service named "RequestFilter" we use an explicit service id that we can reference
     * inside the contribution method.
     */    
    public RequestFilter buildTimingFilter(final Logger log)
    {
        return new RequestFilter()
        {
            public boolean service(Request request, Response response, RequestHandler handler)
                    throws IOException
            {
                long startTime = System.currentTimeMillis();

                try
                {
                    // The responsibility of a filter is to invoke the corresponding method
                    // in the handler. When you chain multiple filters together, each filter
                    // received a handler that is a bridge to the next filter.
                    
                    return handler.service(request, response);
                }
                finally
                {
                    long elapsed = System.currentTimeMillis() - startTime;

                    log.info(String.format("Request time: %d ms", elapsed));
                }
            }
        };
    }

    /**
     * This is a contribution to the RequestHandler service configuration. This is how we extend
     * Tapestry using the timing filter. A common use for this kind of filter is transaction
     * management or security. The @Local annotation selects the desired service by type, but only
     * from the same module.  Without @Local, there would be an error due to the other service(s)
     * that implement RequestFilter (defined in other modules).
     */
    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
            @Local
            RequestFilter filter)
    {
        // Each contribution to an ordered configuration has a name, When necessary, you may
        // set constraints to precisely control the invocation order of the contributed filter
        // within the pipeline.
        
        configuration.add("Timing", filter);
    }
    
	public static void contributeAlias(
			Configuration<AliasContribution<PasswordEncoder>> configuration) {

		configuration.add(AliasContribution.create(PasswordEncoder.class, new ShaPasswordEncoder()));
	}
    
	public static void contributeProviderManager(
			OrderedConfiguration<AuthenticationProvider> configuration,
			@InjectService("DaoAuthenticationProvider") AuthenticationProvider daoAuthenticationProvider) {

		configuration.add("daoAuthenticationProvider", daoAuthenticationProvider);
	}
	
	public static void contributeAccessDecisionManager( 
			OrderedConfiguration<AccessDecisionVoter> configuration ) {

		RoleVoter voter = new RoleVoter();
		voter.setRolePrefix("PERM_");
		// Override the default Voter "ROLE_" with our own "PERM_" 
        configuration.override("RoleVoter", voter);
    }

}
