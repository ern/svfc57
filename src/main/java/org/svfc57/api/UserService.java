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