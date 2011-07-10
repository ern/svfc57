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

package org.svfc57.dao;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.svfc57.entities.User;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	@Inject
	private Session session;

	/* (non-Javadoc)
	 * @see org.svfc57.dao.UserDAO#getUserById(long)
	 */
	@Override
	public User findUser(long id) {
		return (User) session.get(User.class, id);
	}

	/* (non-Javadoc)
	 * @see org.svfc57.dao.UserDAO#getUserByName(long)
	 */
	@Override
	public User findUserByName(String name) {
		return (User) session.createCriteria(User.class).add(Restrictions.eq("username", name)).uniqueResult();
	}
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return session.createCriteria(User.class).list();
	}

}
