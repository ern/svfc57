package org.svfc57.services;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.InjectResource;
import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.svfc57.api.UserService;
import org.svfc57.dao.UserDAO;
import org.svfc57.entities.User;

public class UserServiceImpl implements UserService, UserDetailsService {
	
	@InjectResource
	private Logger logger;
	@Inject
	private UserDAO dao;
	private SaltSource salt;
	private PasswordEncoder encoder;

    public UserServiceImpl( PasswordEncoder encoder, SaltSource salt ) {
    	this.encoder = encoder;
    	this.salt = salt;
        //admin = new User( "admin" );
        //admin.addAuthority( user );
        //admin.addAuthority( new GrantedAuthorityImpl( "ROLE_ADMIN" ) );
        //admin.setPassword( encoder.encodePassword( "admin", salt.getSalt( admin ) ) );
    }

    public UserDetails loadUserByUsername( String name )
        throws UsernameNotFoundException, DataAccessException {
    	
    	User user = dao.getUserByName(name);
    	if (user != null) {
    		
    		// TODO must delete this after creating the User Forms
    		//user.setPassword(encoder.encodePassword("admin", salt.getSalt(user)));
    		//logger.debug("user: " + name + ", password: " + user.getPassword());
    		return user;
    	}
        
        return null;
    }
}
