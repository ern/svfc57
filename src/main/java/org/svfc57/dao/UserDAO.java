package org.svfc57.dao;

import org.svfc57.entities.User;

public interface UserDAO {

	public abstract User getUserById(long id);

	public abstract User getUserByName(String name);

}