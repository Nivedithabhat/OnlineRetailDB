package com.sam.service;

import java.util.List;
import com.sam.entity.*;

public interface UserService {

	public int addUser(User user) throws ServiceException;

	public List<User> getAllUser() throws ServiceException;

	public void updateUser(User user) throws ServiceException;

	public void deleteUser(int userId) throws ServiceException;
	
	public User getUser(int userId) throws ServiceException;
	
}
