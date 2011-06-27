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
