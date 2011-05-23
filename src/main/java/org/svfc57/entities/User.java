package org.svfc57.entities;

import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private static final long serialVersionUID = 5905943605972246434L;

	public long id;
	public String username;
	public String password;
	public boolean expired;
	public boolean locked;
	public boolean enabled;
	private List<GrantedAuthority> authorities = CollectionFactory.newList();
	
	public User(String username) {
		this.username = username;
	}

	public void addAuthority( GrantedAuthority authority ) {
		
		authorities.add( authority );
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
