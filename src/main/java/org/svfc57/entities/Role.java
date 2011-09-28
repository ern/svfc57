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

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class Role {

	@NonVisual
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	public long id;

	public String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ROLE_PERMISSION",
			   joinColumns=@JoinColumn(name="ROLE_ID"),
			   inverseJoinColumns=@JoinColumn(name="PERMISSION_ID"))
	public Set<Permission> permissions;
}
