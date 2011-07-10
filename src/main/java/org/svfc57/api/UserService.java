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

package org.svfc57.api;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.svfc57.entities.User;

/**
 * @author Earle Nietzel
 *
 */
public interface UserService extends UserDetailsService {

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException, DataAccessException;

	/**
	 * @param user
	 * @return true if user was added otherwise false
	 */
	public void addUser(User user);

	/**
	 * @param user
	 * @return true if user was updated otherwise false
	 */
	public void updateUser(User user); 
	
	/**
	 * @param id
	 * @return User object with the requested id
	 */
	public User findUser(long id);
	
	/**
	 * @return a List of all Users
	 */
	public List<User> findAllUsers();
}