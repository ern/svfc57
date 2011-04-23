package org.svfc57.services;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.svfc57.api.UserService;
import org.svfc57.entities.UserImpl;

public class UserServiceImpl implements UserService, UserDetailsService {

	private UserImpl admin;
	private UserImpl mona;

    public UserServiceImpl( PasswordEncoder encoder, SaltSource salt ) {

    	
    	GrantedAuthority user = new GrantedAuthorityImpl( "ROLE_DEFAULT" );
        
        admin = new UserImpl( "admin" );
        admin.addAuthority( user );
        admin.addAuthority( new GrantedAuthorityImpl( "ROLE_ADMIN" ) );
        admin.setPassword( encoder.encodePassword( "admin", salt.getSalt( admin ) ) );

        mona = new UserImpl( "mona");
        mona.addAuthority( user );
        mona.addAuthority( new GrantedAuthorityImpl( "ROLE_TELLER" ) );
        mona.setPassword( encoder.encodePassword( "mona", salt.getSalt( mona ) ) );
    }

    public UserDetails loadUserByUsername( String name )
        throws UsernameNotFoundException,
        DataAccessException {

        if ( "admin".equals( name ) ) return admin;
        if ( "mona".equals( name ) ) return mona;
        return null;
    }
}
