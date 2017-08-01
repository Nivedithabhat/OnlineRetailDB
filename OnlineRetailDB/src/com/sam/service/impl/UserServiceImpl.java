package com.sam.service.impl;

import java.util.List;

import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.dao.UserDao;
import com.sam.entity.User;
import com.sam.service.ServiceException;
import com.sam.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) throws ServiceException {
		try {
			UserDao dao = DaoFactory.getDaoFactory("file").getUserDao();
			return dao.addUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllUser() throws ServiceException {
		try {
			UserDao dao = DaoFactory.getDaoFactory("file").getUserDao();
			return dao.getAllUser();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateUser(User user) throws ServiceException {
		try {
			UserDao dao = DaoFactory.getDaoFactory("file").getUserDao();
			dao.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteUser(int userId) throws ServiceException {
		try {
			UserDao dao = DaoFactory.getDaoFactory("file").getUserDao();
			dao.deleteUser(userId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public User getUser(int userId) throws ServiceException {
		try {
			UserDao dao = DaoFactory.getDaoFactory("file").getUserDao();
			return dao.getUser(userId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
