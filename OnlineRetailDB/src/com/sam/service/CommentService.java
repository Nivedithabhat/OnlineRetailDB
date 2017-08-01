package com.sam.service;

import java.util.List;

import com.sam.entity.Comment;

public interface CommentService {

	 public void addComment(Comment comment) throws ServiceException;

	 public List<Comment> getAllComments() throws ServiceException;
	 
	 public void deleteComment(int id) throws ServiceException;

	 public Comment getComment(int id) throws ServiceException;

}
