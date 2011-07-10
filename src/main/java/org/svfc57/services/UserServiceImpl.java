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

import java.util.List;

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

    /* (non-Javadoc)
	 * @see org.svfc57.services.UserService#loadUserByUsername(java.lang.String)
	 */
    @Override
	public UserDetails loadUserByUsername( String name )
        throws UsernameNotFoundException, DataAccessException {
    	
    	User user = dao.findUserByName(name);
    	if (user != null) {
    		
    		// TODO must delete this after creating the User Forms
    		//user.setPassword(encoder.encodePassword("admin", salt.getSalt(user)));
    		//logger.debug("user: " + name + ", password: " + user.getPassword());
    		return user;
    	}
        
        return null;
    }
    
	@Override
	public void addUser(User user) {

		User newUser = dao.findUserByName(user.username);
		if(newUser == null) {
			// user does not exist so its ok to add
			user.password = encoder.encodePassword(user.password, salt.getSalt(user));
			dao.create(user);
		} 
	}

	@Override
	public void updateUser(User user) {
		
		User currentUser = dao.findUser(user.id);
		
		if(!(user.getPassword().isEmpty())) {
			// User has set password so we need to encrypt it
			user.setPassword(encoder.encodePassword(user.password, salt.getSalt(user)));
		} else {
			// use old password
			user.setPassword(currentUser.password);
		}
			
		dao.update(user);
	}

	@Override
	public User findUser(long id) {
		return dao.findUser(id);
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
}
