package com.sam.service.impl;

import java.util.List;

import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.dao.ProductDao;
import com.sam.entity.Product;
import com.sam.service.ProductService;
import com.sam.service.ServiceException;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) throws ServiceException {
		try {
			ProductDao dao = DaoFactory.getDaoFactory("file").getProductDao();
			dao.addProduct(product);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Product> getAllProduct() throws ServiceException {
		try {
			ProductDao dao = DaoFactory.getDaoFactory("file").getProductDao();
			return dao.getAllProduct();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateProduct(Product product) throws ServiceException {
		try {
			ProductDao dao = DaoFactory.getDaoFactory("file").getProductDao();
			dao.updateProduct(product);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteProduct(int id) throws ServiceException {
		try {
			ProductDao dao = DaoFactory.getDaoFactory("file").getProductDao();
			dao.deleteProduct(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Product getProduct(int id) throws ServiceException {
		try {
			ProductDao dao = DaoFactory.getDaoFactory("file").getProductDao();
			return dao.getProduct(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}


}
