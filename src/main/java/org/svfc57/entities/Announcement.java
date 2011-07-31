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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	public Date modifiedDate;

	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="USER_ID")
	public User modifiedBy;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getShowAfterDate() {
		return showAfterDate;
	}

	public void setShowAfterDate(Date showAfterDate) {
		this.showAfterDate = showAfterDate;
	}

	public Date getShowBeforeDate() {
		return showBeforeDate;
	}

	public void setShowBeforeDate(Date showBeforeDate) {
		this.showBeforeDate = showBeforeDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
