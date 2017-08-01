package com.sam.dao;

import java.util.List;

import com.sam.entity.*;

public interface CategoryDao {

	public void addCategory(Category category) throws DaoException;

	public List<Category> getAllCategories() throws DaoException;

	public void updateCategory(Category category) throws DaoException;

	public void deleteCategory(int categoryId) throws DaoException;

	public Category getCategory(int categoryId) throws DaoException;

	public void addSubCategory(SubCategory subcategory) throws DaoException;

	public List<SubCategory> getAllSubCategories() throws DaoException;

	public void updateSubCategory(SubCategory subcategory) throws DaoException;

	public void deleteSubCategory(int subcategoryId) throws DaoException;

	public SubCategory getSubCategory(int subCategoryId) throws DaoException;

}