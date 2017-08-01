package com.sam.dao;

import java.util.List;

import com.sam.entity.*;

public interface CommentDao {
	 public void addComment(Comment comment) throws DaoException;

	 public List<Comment> getAllComments() throws DaoException;
	 
	 public void deleteComment(int id) throws DaoException;

	 public Comment getComment(int id) throws DaoException;

}