package com.sam.service.impl;

import java.util.List;

import com.sam.dao.CommentDao;
import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.entity.Comment;
import com.sam.service.CommentService;
import com.sam.service.ServiceException;

public class CommentServiceImpl implements CommentService {


	@Override
	 public void addComment(Comment comment) throws ServiceException {
		try {
			CommentDao dao = DaoFactory.getDaoFactory("file").getCommentDao();
			dao.addComment(comment);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Comment> getAllComments() throws ServiceException {
		try {
			CommentDao dao = DaoFactory.getDaoFactory("file").getCommentDao();
			return dao.getAllComments();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteComment(int id) throws ServiceException {
		try {
			CommentDao dao = DaoFactory.getDaoFactory("file").getCommentDao();
			dao.deleteComment(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Comment getComment(int id) throws ServiceException {
		try {
			CommentDao dao = DaoFactory.getDaoFactory("file").getCommentDao();
			return dao.getComment(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
