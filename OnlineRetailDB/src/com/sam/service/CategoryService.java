package com.sam.service;

import java.util.List;

import com.sam.entity.Category;
import com.sam.entity.SubCategory;

public interface CategoryService {

	public void addCategory(Category category) throws ServiceException;

	public List<Category> getAllCategories() throws ServiceException;

	public void updateCategory(Category category) throws ServiceException;
	
	public void deleteCategory(int categoryId) throws ServiceException;

	public void addSubCategory(SubCategory subcategory) throws ServiceException;
	
	public void updateSubCategory(SubCategory subcategory) throws ServiceException;
	
	public void deleteSubCategory(int id) throws ServiceException;
	
	public List<SubCategory> getAllSubCategories() throws ServiceException;
	
	public SubCategory getSubCategory(int id) throws ServiceException;
	
	public Category getCategory(int id) throws ServiceException;
		
}
