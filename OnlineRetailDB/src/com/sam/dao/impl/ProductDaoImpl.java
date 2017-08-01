package com.sam.dao.impl;

import com.sam.dao.*;
import com.sam.entity.*;

import java.util.*;
import java.sql.*;

import static com.sam.dao.impl.ConnectionHelper.*;

public class ProductDaoImpl implements ProductDao {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	@Override
	public void addProduct(Product product) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();

            //Student code here

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void updateProduct(Product product) {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();

            //Student code here

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());

            //Student code here
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void deleteProduct(int id) {
		try {
			con = getMySqlConnection();
			String query = "delete from product where pid = ?";
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
	public List<Product> getAllProduct() throws DaoException {
		try {
			con = getMySqlConnection();
			pstmt = con.prepareStatement("select * from product");
			result = pstmt.executeQuery();
			List<Product> products = new ArrayList<Product>();
			Product product;
			while (result.next()) {
				product = new Product();
				product.setPid(result.getInt("pid"));
				product.setPname(result.getString("productName"));
				product.setPdescription(result.getString("productDescription"));
				product.setCost(result.getInt("cost"));
				product.setSid(result.getInt("sid"));
				products.add(product);
			}
			con.close();
			return products;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	public Product getProduct(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from product where pid = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				pstmt = con.prepareStatement("select * from product where pid = ?");
				pstmt.setInt(1, id);
				result = pstmt.executeQuery();
				Product product = new Product();
				while (result.next()) {
					product.setPid(result.getInt("pid"));
					product.setPname(result.getString("productName"));
					product.setPdescription(result
							.getString("productDescription"));
					product.setCost(result.getInt("cost"));
					product.setSid(result.getInt("sid"));
				}
				con.close();
				return product;
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
