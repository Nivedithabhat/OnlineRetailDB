package com.sam.service;

import java.util.List;

import com.sam.entity.Cart;
import com.sam.entity.Order;

public interface PurchaseProductService {

	 public void addCart(Cart cart) throws ServiceException;

	 public List<Cart> getAllCartDetails() throws ServiceException;
	 
	 public void deleteCart(int id) throws ServiceException;

	 public Cart getCartDetails(int id) throws ServiceException;

	 public void addOrder(Order order) throws ServiceException;

	 public List<Order> getAllOderDetails() throws ServiceException;
	 
	 public void deleteOrder(int id) throws ServiceException;

	 public Order getOrderDetails(int id) throws ServiceException;
	 
	 public Order getOrderCartDetails(int id) throws ServiceException;
}
