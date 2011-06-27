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
