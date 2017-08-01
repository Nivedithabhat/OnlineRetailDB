package com.sam.service;

import com.sam.service.impl.CategoryServiceImpl;
import com.sam.service.impl.CommentServiceImpl;
import com.sam.service.impl.ProductServiceImpl;
import com.sam.service.impl.PurchaseProductServiceImpl;
import com.sam.service.impl.UserServiceImpl;

public class ServiceFactory {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

	public static CategoryService getCategoryService() {
		return new CategoryServiceImpl();
	}

	public static ProductService getProductService() {
		return new ProductServiceImpl();
	}

	public static CommentService getCommentService() {
		return new CommentServiceImpl();
	}

	public static PurchaseProductService getPurchaseProductService() {
		return new PurchaseProductServiceImpl();
	}

}
