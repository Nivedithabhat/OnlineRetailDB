package com.sam.service.impl;

import java.util.List;

import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.dao.PurchaseProductDao;
import com.sam.entity.Cart;
import com.sam.entity.Order;
import com.sam.service.PurchaseProductService;
import com.sam.service.ServiceException;

public class PurchaseProductServiceImpl implements PurchaseProductService {

	@Override
	public void addCart(Cart cart) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			dao.addCart(cart);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Cart> getAllCartDetails() throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			return dao.getAllCartDetails();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteCart(int id) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			dao.deleteCart(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Cart getCartDetails(int id) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			return dao.getCartDetails(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addOrder(Order order) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			dao.addOrder(order);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Order> getAllOderDetails() throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			return dao.getAllOderDetails();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteOrder(int id) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			dao.deleteOrder(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Order getOrderDetails(int id) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			return dao.getOrderDetails(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Order getOrderCartDetails(int id) throws ServiceException {
		try {
			PurchaseProductDao dao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();
			return dao.getOrderCartDetails(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
