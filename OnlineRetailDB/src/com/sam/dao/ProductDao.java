package com.sam.dao;

import java.util.List;

import com.sam.entity.*;

public interface ProductDao {
	public void addProduct(Product product) throws DaoException;

	public List<Product> getAllProduct() throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	public void deleteProduct(int id) throws DaoException;

	public Product getProduct(int id) throws DaoException;

}