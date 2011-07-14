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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonVisual
	@Column(name="PERSON_ID")
	public long id;
	
	@Validate("required")
	public String firstName;
	
	@Validate("required")
	public String lastName;
	
	@Validate("required")
	public String streetOne;
	
	public String streetTwo;
	
	@Validate("required")
	public String city;
	
	@Validate("required")
	public String state;
	
	@Validate("required,regexp")
	public String zip;
	
	@Validate("required")
	public String email;
	
	@Validate("required")
	public String phone;
	
	@NonVisual
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public User user;
}
