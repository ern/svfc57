package org.svfc57.dao;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.svfc57.entities.User;

public class UserDAOImpl implements UserDAO {

	@Inject
	private Session session;

	/* (non-Javadoc)
	 * @see org.svfc57.dao.UserDAO#getUserById(long)
	 */
	@Override
	public User getUserById(long id) {
		return (User) session.get(User.class, id);
	}

	/* (non-Javadoc)
	 * @see org.svfc57.dao.UserDAO#getUserByName(long)
	 */
	@Override
	public User getUserByName(String name) {
		return (User) session.createCriteria(User.class).add(Restrictions.eq("username", name)).uniqueResult();
	}

}
