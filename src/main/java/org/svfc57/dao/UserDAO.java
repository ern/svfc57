package org.svfc57.dao;

import java.util.List;

import org.svfc57.entities.User;

public interface UserDAO extends GenericDAO<User> {

	public User findUser(long id);
	public User findUserByName(String name);
	List<User> findAllUsers();

}