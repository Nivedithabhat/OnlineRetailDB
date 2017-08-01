package com.sam.dao;

import java.util.List;

import com.sam.entity.*;

public interface PurchaseProductDao {
	 public void addCart(Cart cart) throws DaoException;

	 public List<Cart> getAllCartDetails() throws DaoException;
	 
	 public void deleteCart(int id) throws DaoException;

	 public Cart getCartDetails(int id) throws DaoException;

	 public void addOrder(Order order) throws DaoException;

	 public List<Order> getAllOderDetails() throws DaoException;
	 
	 public void deleteOrder(int id) throws DaoException;

	 public Order getOrderDetails(int id) throws DaoException;

	 public Order getOrderCartDetails(int cartid) throws DaoException;

}