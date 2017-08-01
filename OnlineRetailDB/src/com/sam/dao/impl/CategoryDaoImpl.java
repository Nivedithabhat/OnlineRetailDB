package com.sam.dao.impl;

import com.sam.dao.CategoryDao;
import com.sam.dao.DaoException;
import com.sam.entity.*;

import java.sql.*;
import java.util.*;

import static com.sam.dao.impl.ConnectionHelper.*;

public class CategoryDaoImpl implements CategoryDao {

	
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Connection con = null;

	@Override
	public void addCategory(Category category) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from category where cname = '"
							+ category.getCname() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();

			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from category where cid = '"
							+ category.getCid() + "'");
			result.next();
			int count1 = result.getInt(1);
			stmt.close();

			if (count == 0 && count1 == 0) {
				String query = "insert into category(cid,cname,description)"
						+ " values(?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, category.getCid());
				pstmt.setString(2, category.getCname());
				pstmt.setString(3, category.getDescription());
				pstmt.executeUpdate();
				con.close();
			} else {
				System.out.println("Information already exists");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public List<Category> getAllCategories() throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from category");
			List<Category> categories = new ArrayList<Category>();
			Category category;
			while (result.next()) {
				category = new Category();
				category.setCid(result.getInt("cid"));
				category.setCname(result.getString("cname"));
				category.setDescription(result.getString("description"));
				categories.add(category);
			}
			con.close();
			return categories;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	@Override
	public void updateCategory(Category category) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from category where cname = '"
							+ category.getCname() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();
			if (count == 0) {
				con = getMySqlConnection();
				String query = "update category set cname = ?,description = ? where cid = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, category.getCname());
				pstmt.setString(2, category.getDescription());
				pstmt.setInt(3, category.getCid());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void deleteCategory(int categoryId) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "delete from category where cid = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, categoryId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.cleanup(con, stmt, null);
		}
	}

	@Override
	public void addSubCategory(SubCategory subcategory) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from subcategory where subname = '"
							+ subcategory.getSubcname() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();

			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from subcategory where sid = '"
							+ subcategory.getSid() + "'");
			result.next();
			int count1 = result.getInt(1);
			stmt.close();

			if (count == 0 && count1 == 0) {
				String query = "insert into subcategory(sid,subname,subdescription,cid)"
						+ " values(?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, subcategory.getSid());
				pstmt.setString(2, subcategory.getSubcname());
				pstmt.setString(3, subcategory.getSdescription());
				pstmt.setInt(4, subcategory.getCid());
				pstmt.executeUpdate();
			} else {
				System.out.println("Information already exists");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void updateSubCategory(SubCategory subcategory) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from subcategory where subname = '"
							+ subcategory.getSubcname() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();
			if (count == 0) {
				String query = "update subCategory set subname = ?,subDescription = ? where sid = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, subcategory.getSubcname());
				pstmt.setString(2, subcategory.getSdescription());
				pstmt.setInt(3, subcategory.getSid());
				pstmt.executeUpdate();
				con.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void deleteSubCategory(int id) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "delete from subcategory where sid = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.cleanup(con, stmt, null);
		}
	}

	@Override
	public List<SubCategory> getAllSubCategories() throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from subcategory");
			List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
			while (result.next()) {
				SubCategory subcategory = new SubCategory();
				subcategory.setSid(result.getInt("sid"));
				subcategory.setSubcname(result.getString("subName"));
				subcategory.setSdescription(result.getString("subDescription"));
				subcategory.setCid(result.getInt("cid"));
				subCategoryList.add(subcategory);
			}
			con.close();
			return subCategoryList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	@Override
	public SubCategory getSubCategory(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from subcategory where sid = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt
						.executeQuery("select * from subcategory where sid = "
								+ id);
				SubCategory subcategory = new SubCategory();
				while (result.next()) {
					subcategory.setSid(result.getInt("sid"));
					subcategory.setSubcname(result.getString("subName"));
					subcategory.setSdescription(result
							.getString("subDescription"));
					subcategory.setCid(result.getInt("cid"));
				}
				return subcategory;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionHelper.cleanup(con, stmt, result);
		}
	}

	@Override
	public Category getCategory(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from category where cid = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt
						.executeQuery("select * from category where cid = "
								+ id);
				Category category = new Category();
				while (result.next()) {
					category.setCid(result.getInt("cid"));
					category.setCname(result.getString("cname"));
					category.setDescription(result.getString("description"));
				}
				return category;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionHelper.cleanup(con, stmt, result);
		}
	}

}
