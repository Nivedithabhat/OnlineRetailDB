package com.sam.dao;

import java.util.Arrays;
import java.util.List;

import com.sam.dao.impl.CategoryDaoImpl;
import com.sam.dao.impl.CommentDaoImpl;
import com.sam.dao.impl.ProductDaoImpl;
import com.sam.dao.impl.PurchaseProductDaoImpl;
import com.sam.dao.impl.UserDaoImpl;

public class DaoFactory {
	private String impl = "file";
	private static DaoFactory instance = null;

	private DaoFactory() {
	}

	public static DaoFactory getDaoFactory(String impl) throws DaoException {
		if (instance == null) {
			List<String> availableImpls = Arrays.asList("file");
			if (!availableImpls.contains(impl)) {
				throw new DaoException("Implementation type not avilable");
			}
			instance = new DaoFactory();
			instance.impl = impl.toLowerCase();
		}
		return instance;
	}

	public UserDao getUserDao() {
		if (impl.equals("file")) {
			return new UserDaoImpl();
		}
		return null;
	}

	public CategoryDao getCategoryDao() {
		if (impl.equals("file")) {
			return new CategoryDaoImpl();
		}
		return null;
	}

	public ProductDao getProductDao() {
		if (impl.equals("file")) {
			return new ProductDaoImpl();
		}
		return null;
	}

	public CommentDao getCommentDao() {
		if (impl.equals("file")) {
			return new CommentDaoImpl();
		}
		return null;
	}

	public PurchaseProductDao getPurchaseProductDao() {
		if (impl.equals("file")) {
			return new PurchaseProductDaoImpl();
		}
		return null;
	}

}
