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

package org.svfc57.entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	@NonVisual
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public long id;
	
	@Validate("required")
	public String username;
	
	@Validate("required")
	public String password;
	
	@Validate("required")
	public boolean enabled;
	
	@Validate("required")
	public boolean accountNonLocked;
	
	@Validate("required")
	public boolean accountNonExpired;
	
	@Validate("required")
	public boolean credentialsNonExpired;
	
	@NonVisual
	@OneToOne(mappedBy="user")
	public Person person;
		
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
			   joinColumns=@JoinColumn(name="USER_ID"),
			   inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	public Set<Role> roles;

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = CollectionFactory.newList();
		for (Role r : roles) {	
			for (Permission p : r.permissions) {
				authorities.add(new GrantedAuthorityImpl(p.name));
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		if (person != null) {
			this.person = person;
		}
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}
}
