package com.sam.dao;

import java.util.List;

import com.sam.entity.*;

public interface UserDao {
	public int addUser(User user) throws DaoException;

	public List<User> getAllUser() throws DaoException;

	public void updateUser(User user) throws DaoException;

	public void deleteUser(int userId) throws DaoException;
	
	public User getUser(int userId) throws DaoException;
	
	public User getUsersByMobileNumber(String mobileNo) throws DaoException;
}
