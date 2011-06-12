package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.User;

public interface UserDAO<T> extends GenericDAO<T> {

	public abstract User getUserById(long id);

	public abstract User getUserByName(String name);

	List<User> getUsers();

}