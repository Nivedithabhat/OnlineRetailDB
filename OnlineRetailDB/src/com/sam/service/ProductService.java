package com.sam.service;

import java.util.List;

import com.sam.entity.*;

public interface ProductService {

	public void addProduct(Product product) throws ServiceException;

	public List<Product> getAllProduct() throws ServiceException;

	public void updateProduct(Product product) throws ServiceException;

	public void deleteProduct(int id) throws ServiceException;

	public Product getProduct(int id) throws ServiceException;
}
