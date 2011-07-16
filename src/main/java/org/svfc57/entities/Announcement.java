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

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity(name="Announcement")
public class Announcement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonVisual
	public long id;
	
	@Temporal(TemporalType.DATE)
	public Date createDate;
	
	@Temporal(TemporalType.DATE)
	public Date modifiedDate;

	public long createdBy;
	
	public long modifiedBy;

	@Validate("required")
	public String title;

	@Validate("required")
	public String text;

	@Validate("required")
	public boolean active;
	
	@Validate("required")
	@Temporal(TemporalType.DATE)
	public Date showAfterDate;
	
	@Validate("required")
	@Temporal(TemporalType.DATE)
	public Date showBeforeDate;
	
	@NonVisual
	public boolean deleted;
	
}
