package com.sam.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sam.entity.*;
import com.sam.service.*;
import com.sam.util.KeyboardUtil;

public class Main {

	public static void main(String[] args) {
		new Main().start();
	}

	public void start() {
		int choice;

		the_loop: while ((choice = mainMenu()) != 99) {
			switch (choice) {
			case 1:
				handleUsersMenu();
				break;
			case 2:
				handleCategoryMenu();
				break;
			case 3:
				handleProductMenu();
				break;
			case 4:
				handleCommentMenu();
				break;
			case 5:
				handleBuyProductMenu();
				break;
			case 0:
				// ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");
			}

		}

		System.out.println("The application is terminated");
		System.out.println("Thanks for using the Online Retail System");
	}

	private int mainMenu() {
		line("-", 40);
		System.out.println("Online Retail System");
		line("-", 40);
		System.out.println("1.  Users");
		System.out.println("2.  Category and SubCategory");
		System.out.println("3.  Product");
		System.out.println("4.  Comment");
		System.out.println("5.  Search Product and Buy Product");
		System.out.println("99. Exit");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}

	private int usersMenu() {
		line("-", 40);
		System.out.println("Users Menu");
		line("-", 40);
		System.out.println("1.  Add new user data");
		System.out.println("2.  Search and modify the user data");
		System.out.println("3.  Delete user data");
		System.out.println("4.  List all users");
		System.out.println("99. Back");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}

	private int categoryMenu() {
		line("-", 40);
		System.out.println("Category and Sub Category Menu");
		line("-", 40);
		System.out.println(" 1. Add Category data");
		System.out.println(" 2. Search and modify the category data");
		System.out.println(" 3. Delete category data");
		System.out.println(" 4. List all category");
		System.out.println(" 5. Add Sub Category data");
		System.out.println(" 6. Search and modify sub category data");
		System.out.println(" 7. Delete sub category data");
		System.out.println(" 8. List all sub category");

		System.out.println("99. Back");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}

	private int productMenu() {
		line("-", 40);
		System.out.println("Product Menu");
		line("-", 40);
		System.out.println(" 1. Add new product");
		System.out.println(" 2. Search and modify the product data");
		System.out.println(" 3. Delete product data");
		System.out.println(" 4. List all product");
		System.out.println("99. Back");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}

	private int commentMenu() {
		line("-", 40);
		System.out.println("Comment Menu");
		line("-", 40);
		System.out.println(" 1. Add new comment");
		System.out.println(" 2. Delete comment");
		System.out.println(" 3. List all comment");
		System.out.println("99. Back");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}

	private int buyProductMenu() {
		line("-", 40);
		System.out.println("Search and Buy Product Menu");
		line("-", 40);
		System.out.println(" 1. Buy Product");
		System.out.println(" 2. Delete buy product");
		System.out.println(" 3. List all buy products");
		System.out.println("99. Back");
		try {
			String input = KeyboardUtil.getString("Enter your choice: [99] ");
			if (input.equals("")) {
				input = "99";
			}
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Invalid input, please retry.");
		}
		return 0;
	}
	
	private void handleUsersMenu() {
		int choice;
		the_loop: while ((choice = usersMenu()) != 99) {
			switch (choice) {
			case 1: // Add new user data
				addNewUser();
				break;
			case 2: // Search and modify the user data
				searchAndModifyUser();
				break;
			case 3: // Delete user data
				deleteUserData();
				break;
			case 4: // List all users
				listAllUsers();
				break;
			case 0:
				// ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");
			}

		}
	}

	private void addNewUser() {
		try {
		    int userId = KeyboardUtil.getInt("Enter user id: ");
			String username = KeyboardUtil.getString("Enter username: ");
			String mobileNumber = KeyboardUtil
					.getString("Enter mobile number: ");
			String gender = KeyboardUtil.getString("Enter gender: ");
			String city = KeyboardUtil.getString("Enter city: ");
			String country = KeyboardUtil.getString("Enter country: ");

			 User user = new User(userId,username,
					 mobileNumber,gender,city,country);
						
			UserService service = ServiceFactory.getUserService();
			service.addUser(user);

		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the user data");
			System.out.println(e.getMessage());
		}

		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void searchAndModifyUser() {

		UserService service;
		try {
			service = ServiceFactory.getUserService();
			int id = KeyboardUtil.getInt("Enter user's id to edit: ");
			User user = service.getUser(id);
			if (user == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("User data: ");
				System.out.println("-----------");
				System.out.println("Username       : " + user.getUsername());
				System.out
						.println("Mobile number  : " + user.getPhnnumber());
				System.out.println("City        : " + user.getCity());
				System.out.println("Country       : " + user.getCountry());

				String ans = KeyboardUtil
						.getString("Do you wish to edit this user? yes/no: [yes] ");
				if (ans.equals("") || ans.equalsIgnoreCase("yes")) {
					String input;
					input = KeyboardUtil.getString("Mobile number  : ["
							+ user.getPhnnumber() + "] ");
					if (!input.equals("")) {
						user.setPhnnumber(input);
					}
					input = KeyboardUtil.getString("City         : ["
							+ user.getCity() + "] ");
					if (!input.equals("")) {
						user.setCity(input);
					}
					input = KeyboardUtil.getString("Country         : ["
							+ user.getCountry() + "] ");
					if (!input.equals("")) {
						user.setCity(input);
					}
					
					service.updateUser(user);
				}
			}

		} catch (Exception e) {
			System.out.println("There was a problem while updating user data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void deleteUserData() {
		UserService service;
		try {
			service = ServiceFactory.getUserService();
			int id = KeyboardUtil.getInt("Enter user's id to delete: ");

			User user = service.getUser(id);
			if (user == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("User data: ");
				System.out.println("-----------");
				System.out.println("Username       : " + user.getUsername());
				System.out
						.println("Mobile number  : " + user.getPhnnumber());
				System.out.println("City        : " + user.getCity());
				System.out.println("Country       : " + user.getCountry());

				String ans = KeyboardUtil
						.getString("Are you sure to delete this user? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteUser(id);
					System.out.println("User data deleted successfully!");
				} else {
					System.out.println("User data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting user data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");

	}

	private void listAllUsers() {
		UserService service;
		try {
			service = ServiceFactory.getUserService();
			List<User> list = service.getAllUser();

			line("=", 100);
			System.out.printf("%4s | %-15s | %-15s | %-15s | %-15s | %-40s\n", "ID",
					"Username", "Mobile#", "Gender", "City", "Country");
			line("=", 100);
			for (User user : list) {
				System.out.printf("%4s | %-15s | %-15s | %-15s | %-15s | %-40s\n",
						user.getId(), user.getUsername(),
						user.getPhnnumber(), user.getGender(), user.getCity(),
						user.getCountry());
			}
			line(".", 100);
		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all users");
			System.out.println(e.getMessage());
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}

	private void handleCategoryMenu() {
		int choice;
		the_loop: while ((choice = categoryMenu()) != 99) {
			switch (choice) {
			case 1: // Add new category data
				addCategory();
				break;
			case 2: // Search and modify the category data
				searchAndModifyCategory();
				break;
			case 3: // Delete category data
				deleteCategory();
				break;
			case 4: // List all categories
				listAllCategories();
				break;
			case 5: // Add new sub category
				addSubCategory();
				break;
			case 6: // Search and modify sub category
				searchAndModifySubCategory();
				break;
			case 7: // Delete a sub category
				deleteSubCategory();
				break;
			case 8: // List all sub categories
				listAllSubCategories();
				break;
			case 0: // ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");

			}

		}
	}

	private void addCategory() {
		try {
		    int id = KeyboardUtil.getInt("Enter category id: ");
			String name = KeyboardUtil.getString("Enter name: ");
			String description = KeyboardUtil.getString("Enter description: ");

			Category category = new Category(id,name, description);
			CategoryService service = ServiceFactory.getCategoryService();
			service.addCategory(category);

		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the category data");
			System.out.println(e.getMessage());
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}

	private void searchAndModifyCategory() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter category id to edit: ");
			Category category = service.getCategory(id);
			if (category == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Category data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + category.getCname());
				System.out.println("Description  : " + category.getDescription());

				String ans = KeyboardUtil
						.getString("Do you wish to edit this category? yes/no: [yes] ");
				if (ans.equals("") || ans.equalsIgnoreCase("yes")) {
					String input;
					input = KeyboardUtil.getString("Name  : ["
							+ category.getCname() + "] ");
					if (!input.equals("")) {
						category.setCname(input);
					}
					input = KeyboardUtil.getString("Description  : ["
							+ category.getDescription() + "] ");
					if (!input.equals("")) {
						category.setDescription(input);
					}
					
					service.updateCategory(category);
				}
			}

		} catch (Exception e) {
			System.out.println("There was a problem while updating category data");
			e.printStackTrace();
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void deleteCategory() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter category id to delete: ");
			Category category = service.getCategory(id);
			if (category == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Category data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + category.getCname());
				System.out.println("Description  : " + category.getDescription());

				String ans = KeyboardUtil
						.getString("Are you sure to delete this category? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteCategory(id);
					System.out.println("Category data deleted successfully!");
				} else {
					System.out.println("Category data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting category data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");

	}

	private void listAllCategories() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			List<Category> list = service.getAllCategories();

			line("=", 100);
			System.out.printf("%4s | %-15s | %-50s\n", "ID", "Name", "Description");
			line("=", 100);

			for (Category category : list) {
				System.out.printf("%4d | %-15s | %-50s\n", category.getCid(),
						category.getCname(),category.getDescription());
			}
			line(".", 100);

		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all the categories");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void addSubCategory() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter id: ");
			String name = KeyboardUtil.getString("Enter name: ");
			String description = KeyboardUtil.getString("Enter description: ");

			System.out.println("Category Details");
			listAllCategories();
			
			int categoryId = KeyboardUtil.getInt("Enter Category id: ");
			Category category = service.getCategory(categoryId);
			if (category == null) {
				System.out.println("Invalid Category Id");
				return;
			}
			
			System.out.println("Category Name        : " + category.getCname());
			SubCategory subcategory = new SubCategory(id,name, description,category.getCid());
			service.addSubCategory(subcategory);

		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the subcategory data");
			System.out.println(e.getMessage());
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}

	private void searchAndModifySubCategory() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter sub category id to edit: ");
			SubCategory subcategory = service.getSubCategory(id);
			if (subcategory == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Sub Category data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + subcategory.getSubcname());
				System.out.println("Description  : " + subcategory.getSdescription());

				Category category = service.getCategory(subcategory.getCid());
				System.out.println("Category Name  : " + category.getCname());
				
				String ans = KeyboardUtil
						.getString("Do you wish to edit this sub catgeory? yes/no: [yes] ");
				if (ans.equals("") || ans.equalsIgnoreCase("yes")) {
					String input;
					input = KeyboardUtil.getString("Name  : ["
							+ subcategory.getSubcname() + "] ");
					if (!input.equals("")) {
						subcategory.setSubcname(input);
					}
					input = KeyboardUtil.getString("Description  : ["
							+ subcategory.getSdescription() + "] ");
					if (!input.equals("")) {
						subcategory.setSdescription(input);
					}
					
					service.updateSubCategory(subcategory);
				}
			}

		} catch (Exception e) {
			System.out.println("There was a problem while updating sub category data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void deleteSubCategory() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter sub category id to delete: ");

			SubCategory subcategory = service.getSubCategory(id);
			if (subcategory == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Sub Category data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + subcategory.getSubcname());
				System.out.println("Description  : " + subcategory.getSdescription());

				Category category = service.getCategory(subcategory.getCid());
				System.out.println("Category Name  : " + category.getCname());

				String ans = KeyboardUtil
						.getString("Are you sure to delete this sub category? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteSubCategory(id);
					System.out.println("Sub Category data deleted successfully!");
				} else {
					System.out.println("Sub Category data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting sub category data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");

	}

	private void listAllSubCategories() {
		CategoryService service;
		try {
			service = ServiceFactory.getCategoryService();
			List<SubCategory> list = service.getAllSubCategories();
			
			line("=", 100);
			System.out.printf("%4s | %-15s | %-25s | %-50s\n", "ID", "Name", "Description", "Category Name");
			line("=", 100);

			for (SubCategory subcategory : list) {
				Category category = service.getCategory(subcategory.getCid());	
				System.out.printf("%4d | %-15s | %-25s | %-50s\n", subcategory.getSid(),
						subcategory.getSubcname(),subcategory.getSdescription(),category.getCname());

			}
			line(".", 100);

		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all the sub categories");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void handleProductMenu() {
		int choice;
		the_loop: while ((choice = productMenu()) != 99) {
			switch (choice) {
			case 1: // Add new product data
				addNewProduct();
				break;
			case 2: // Search and modify the product data
				searchAndModifyProduct();
				break;
			case 3: // Delete product data
				deleteProduct();
				break;
			case 4: // List all products
				listAllProduct();
				break;
			case 0: // ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");
			}

		}
	}

	private void addNewProduct() {
		ProductService service;
		CategoryService categoryService;
		try {
			service = ServiceFactory.getProductService();
			categoryService = ServiceFactory.getCategoryService();
			int id = KeyboardUtil.getInt("Enter product id: ");
			String name = KeyboardUtil.getString("Enter name: ");
			String description = KeyboardUtil.getString("Enter description: ");
			int price = KeyboardUtil.getInt("Enter the price: ");
			
			System.out.println("Sub Category Details");
			listAllSubCategories();
			
			int subcategoryId = KeyboardUtil.getInt("Enter Sub Category id: ");
			SubCategory subcategory = categoryService.getSubCategory(subcategoryId);
			if (subcategory == null) {
				System.out.println("Invalid Sub Category Id");
				return;
			}
			
			System.out.println("Sub Category Name        : " + subcategory.getSubcname());
			Product product = new Product(id,name, description,price,subcategoryId);
			service.addProduct(product);

		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the product data");
			System.out.println(e.getMessage());
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}

	private void searchAndModifyProduct() {
		ProductService service;
		try {
			service = ServiceFactory.getProductService();
			int id = KeyboardUtil.getInt("Enter product id to edit: ");
			Product product = service.getProduct(id);
			if (product == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Product data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + product.getPname());
				System.out.println("Description  : " + product.getPdescription());
				System.out.println("Price  : " + product.getCost());

				CategoryService serviceCategory = ServiceFactory.getCategoryService();
				SubCategory subcategory = serviceCategory.getSubCategory(product.getSid());
				System.out.println("Sub Category Name  : " + subcategory.getSubcname());
				
				String ans = KeyboardUtil
						.getString("Do you wish to edit this product? yes/no: [yes] ");
				if (ans.equals("") || ans.equalsIgnoreCase("yes")) {
					String input;
					input = KeyboardUtil.getString("Name  : ["
							+ product.getPname() + "] ");
					if (!input.equals("")) {
						product.setPname(input);
					}
					input = KeyboardUtil.getString("Description  : ["
							+ product.getPdescription() + "] ");
					if (!input.equals("")) {
						product.setPdescription(input);
					}
					input = KeyboardUtil.getString("Price: ["
							+ product.getCost() + "] ");
					if (!input.equals("")) {
						product.setCost(Integer.parseInt(input));
						service.updateProduct(product);
						System.out.println("Product updated successfully!");
					} else {
						System.out.println("Nothing changed.");
					}
					
				}
			}

		} catch (Exception e) {
			System.out.println("There was a problem while updating product data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void deleteProduct() {
		ProductService service;
		try {
			service = ServiceFactory.getProductService();
			int id = KeyboardUtil.getInt("Enter product id to delete: ");
			Product product = service.getProduct(id);
			if (product == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Product data: ");
				System.out.println("-----------");
				System.out.println("Name         : " + product.getPname());
				System.out.println("Description  : " + product.getPdescription());
				System.out.println("Price  : " + product.getCost());

				CategoryService serviceCategory = ServiceFactory.getCategoryService();
				SubCategory subcategory = serviceCategory.getSubCategory(product.getSid());
				System.out.println("Sub Category Name  : " + subcategory.getSubcname());

				String ans = KeyboardUtil
						.getString("Are you sure to delete this product? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteProduct(id);
					System.out.println("Product data deleted successfully!");
				} else {
					System.out.println("Product data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting product data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void listAllProduct() {
		ProductService service;
		try {
			service = ServiceFactory.getProductService();
			List<Product> list = service.getAllProduct();
			
			line("=", 100);
			System.out.printf("%4s | %-15s | %-25s | %-15s | %-50s\n", "ID", "Name", "Description", "Price", "Sub Category Name");
			line("=", 100);

			for (Product product : list) {
				CategoryService serviceCategory = ServiceFactory.getCategoryService();
				SubCategory subcategory = serviceCategory.getSubCategory(product.getSid());
				System.out.printf("%4s | %-15s | %-25s | %-15d | %-50s\n", product.getPid(),
						product.getPname(), product.getPdescription(), product.getCost(), subcategory.getSubcname());

			}
			line(".", 100);

		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all the product");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void handleCommentMenu() {
		int choice;
		the_loop: while ((choice = commentMenu()) != 99) {
			switch (choice) {
			case 1: // Book a show
				addComments();
				break;
			case 2: // Delete booking
				deleteComment();
				break;
			case 3: // List all bookings
				listAllComments();
				break;
			case 0: // ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");
			}

		}
	}

	private void addComments() {
		CommentService service;
		CategoryService categoryService;
		try {
			service = ServiceFactory.getCommentService();
			categoryService = ServiceFactory.getCategoryService();
			
			System.out.println("Category Details");
			listAllCategories();
			
			int categoryId = KeyboardUtil.getInt("Enter Category id: ");
			Category category = categoryService.getCategory(categoryId);
			if (category == null) {
				System.out.println("Invalid Category Id");
				return;
			}
			
			System.out.println("Category Name        : " + category.getCname());
			String remarks = KeyboardUtil.getString("Enter Remarks: ");
			
			Comment comment = new Comment(categoryId,remarks);
			service.addComment(comment);

		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the comment data");
			System.out.println(e.getMessage());
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}

	private void deleteComment() {
		CommentService service;
		try {
			service = ServiceFactory.getCommentService();
			int id = KeyboardUtil.getInt("Enter comment id to delete: ");
			Comment comment = service.getComment(id);
			if (comment == null) {
				System.out.println("No data found for the id " + id);
			} else {
				System.out.println("Comment data: ");
				System.out.println("-----------");
				CategoryService serviceCategory = ServiceFactory.getCategoryService();
				Category category = serviceCategory.getCategory(comment.getCategoryId());
				System.out.println("Category Name  : " + category.getCname());
				System.out.println("Remarks      : " + comment.getComment());

				String ans = KeyboardUtil
						.getString("Are you sure to delete this comment? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteComment(id);
					System.out.println("Comment data deleted successfully!");
				} else {
					System.out.println("Comment data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting comment data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void listAllComments() {
		CommentService service;
		try {
			service = ServiceFactory.getCommentService();
			List<Comment> list = service.getAllComments();
			
			line("=", 100);
			System.out.printf("%4s | %-25s | %-50s\n", "ID", "Category Name", "Remarks");
			line("=", 100);

			for (Comment comment : list) {
				CategoryService serviceCategory = ServiceFactory.getCategoryService();
				Category category = serviceCategory.getCategory(comment.getCategoryId());
				System.out.printf("%4s | %-25s | %-50s\n", comment.getId(),
						category.getCname(), comment.getComment());

			}
			line(".", 100);

		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all the comment");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}

	private void handleBuyProductMenu() {
		int choice;
		the_loop: while ((choice = buyProductMenu()) != 99) {
			switch (choice) {
			case 1: // Add new Cart and Order data
				addCartandOrder();
				break;
			case 2: // Delete Cart and Order data
				deleteCartandOrder();
				break;
			case 3: // List all Cart and Order
				listAllCartandOrder();
				break;
			case 0:
				// ignore
				break;
			case 99:
				break the_loop;
			default:
				System.out.println("***** INVALID CHOICE *****");
			}

		}
	}

	private void addCartandOrder() {
		PurchaseProductService service;
		ProductService productService;
		UserService userService;
		try {
			service = ServiceFactory.getPurchaseProductService();
			productService = ServiceFactory.getProductService();
			userService = ServiceFactory.getUserService();
			
			
			int cartId = KeyboardUtil.getInt("Enter Cart id: ");
			
			System.out.println("Product Details");
			listAllProduct();
			
			int productId = KeyboardUtil.getInt("Enter Product id: ");
			Product product = productService.getProduct(productId);
			if (product == null) {
				System.out.println("Invalid Product Id");
				return;
			}
			
			System.out.println("Product Name        : " + product.getPname());
			int qty = KeyboardUtil.getInt("Enter Quantity: ");
			int total = product.getCost() * qty;
			
			int userId = KeyboardUtil.getInt("Enter User id: ");
			User user = userService.getUser(userId);
			if (user == null) {
				System.out.println("Invalid User Id");
				return;
			}
			
			System.out.println("User Name        : " + user.getUsername());
			
			Date today = stringToDate(dateToString(new Date()));
			
			Cart cart = new Cart(cartId,productId,qty,userId);
			service.addCart(cart);
			
			int id = KeyboardUtil.getInt("Enter order id: ");
			
			Order order = new Order(id,today,cartId,total);
			service.addOrder(order);
			
		} catch (Exception e) {
			System.out
					.println("There was a problem while adding the Cart and Order data");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			KeyboardUtil.getString("\nPress ENTER key to continue...");
		}
	}
	
	private void deleteCartandOrder() {
		PurchaseProductService service;
		try {
			service = ServiceFactory.getPurchaseProductService();
			int id = KeyboardUtil.getInt("Enter order id to delete: ");
			Order order = service.getOrderDetails(id);
			if (order == null) {
				System.out.println("No data found for the id " + id);
			} else {
				Cart cart = service.getCartDetails(order.getId());

				ProductService serviceProduct = ServiceFactory.getProductService();
				Product product = serviceProduct.getProduct(cart.getProdId());

				UserService serviceUser = ServiceFactory.getUserService();
				User user = serviceUser.getUser(cart.getUserId());
				
				System.out.println("Order and Cart data: ");
				System.out.println("-----------");
				System.out.println("Order Id        : " + order.getOrderId());
				System.out.println("Order Date      : " + order.getOrderDate());
				System.out.println("Name            : " + user.getUsername());
				System.out.println("Cart Id         : " + cart.getId());
				System.out.println("Qty             : " + cart.getQty());
				System.out.println("Price           : " + product.getCost());
				System.out.println("Total           : " + order.getTotalAmount());
								
				String ans = KeyboardUtil
						.getString("Are you sure to delete this order & cart? yes/no: [no] ");
				if (ans.equalsIgnoreCase("yes")) {
					service.deleteOrder(id);
					service.deleteCart(order.getId());
					System.out.println("Order data deleted successfully!");
				} else {
					System.out.println("Order data was not deleted!");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("There was a problem while deleting comment data");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
	}
	
	private void listAllCartandOrder() {
		PurchaseProductService service;
		try {
			service = ServiceFactory.getPurchaseProductService();
			List<Cart> list = service.getAllCartDetails();
			
			line("=", 140);
			System.out.printf("%15s | %-15s |  %-15s |  %-15s |  %-15s |  %-15s | %-50s\n", "Cart ID", "Product Name", "Qty" , "Order Id" , "Order Date", "User Name", "Total");
			line("=", 140);

			for (Cart cart : list) {
				ProductService serviceProduct = ServiceFactory.getProductService();
				Product product = serviceProduct.getProduct(cart.getProdId());
				
				UserService serviceUser = ServiceFactory.getUserService();
				User user = serviceUser.getUser(cart.getUserId());
				
				Order order = service.getOrderCartDetails(cart.getId());
				
				System.out.printf("%15s | %-15s |  %-15s |  %-15s |  %-15s |  %-15s | %-50s\n", cart.getId(),
						product.getPname(), cart.getQty(), order.getOrderId(),
						dateToString(order.getOrderDate()), user.getUsername(), 
						order.getTotalAmount());

			}
			line(".", 100);

		} catch (ServiceException e) {
			System.out.println("There was a problem while listing all the comment");
			System.out.println(e.getMessage());
		}
		KeyboardUtil.getString("\nPress ENTER key to continue...");
		
	}
	
	private void line(String str, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(str);
		}
		System.out.println();
	}
	
	private Date stringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	private String dateToString(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dt);
	}
}
