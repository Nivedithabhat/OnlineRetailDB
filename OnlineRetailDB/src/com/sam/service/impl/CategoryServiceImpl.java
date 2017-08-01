package com.sam.service.impl;

import java.util.List;

import com.sam.dao.CategoryDao;
import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.entity.Category;
import com.sam.entity.SubCategory;
import com.sam.service.CategoryService;
import com.sam.service.ServiceException;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public void addCategory(Category category) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.addCategory(category);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Category> getAllCategories() throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			return dao.getAllCategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateCategory(Category category) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.updateCategory(category);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteCategory(int categoryId) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.deleteCategory(categoryId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addSubCategory(SubCategory subcategory) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.addSubCategory(subcategory);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateSubCategory(SubCategory subcategory)
			throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.updateSubCategory(subcategory);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteSubCategory(int id) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			dao.deleteSubCategory(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SubCategory> getAllSubCategories() throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			return dao.getAllSubCategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public SubCategory getSubCategory(int id) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			return dao.getSubCategory(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Category getCategory(int id) throws ServiceException {
		try {
			CategoryDao dao = DaoFactory.getDaoFactory("file").getCategoryDao();
			return dao.getCategory(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}