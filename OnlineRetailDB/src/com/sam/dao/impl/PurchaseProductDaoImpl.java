package com.sam.dao.impl;

import com.sam.dao.*;
import com.sam.entity.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static com.sam.dao.impl.ConnectionHelper.*;

public class PurchaseProductDaoImpl implements PurchaseProductDao {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	@Override
	public void addCart(Cart cart) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select count(*) from cart where id = '" + cart.getId() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();

			if (count == 0) {
				String query = "insert into cart(id,productid,qty,userid)" + " values(?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cart.getId());
				pstmt.setInt(2, cart.getProdId());
				pstmt.setInt(3, cart.getQty());
				pstmt.setInt(4, cart.getUserId());
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
	public List<Cart> getAllCartDetails() throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from cart");
			List<Cart> carts = new ArrayList<Cart>();
			Cart cart;
			while (result.next()) {
				cart = new Cart();
				cart.setId(result.getInt("id"));
				cart.setProdId(result.getInt("productId"));
				cart.setQty(result.getInt("qty"));
				cart.setUserId(result.getInt("userId"));
				carts.add(cart);
			}
			con.close();
			return carts;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	@Override
	public void deleteCart(int id) throws DaoException {

		try {
			con = getMySqlConnection();
			String query = "delete from cart where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			con.close();

			// Student code here

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.cleanup(con, stmt, null);
		}
	}

	@Override
	public Cart getCartDetails(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			stmt=(Statement) con.createStatement();
			result=stmt.executeQuery("select * from cart where id="+id);
			Cart cart=new Cart();
			cart.setId(result.getInt("id"));
			cart.setProdId(result.getInt("productId"));
			cart.setQty(result.getInt("qty"));
			cart.setUserId(result.getInt("userId"));
			con.close();
			return cart;

			// Student code here

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionHelper.cleanup(con, stmt, result);
		}
	}

	@Override
	public void addOrder(Order order) throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select count(*) from orderproduct where id = '" + order.getOrderId() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();

			if (count == 0) {

				String query = "insert into orderproduct(id,orderdate,cartid,total)"
						+ " values(?,to_date(?,'DD/MM/YY'),?,?)";
				pstmt = con.prepareStatement(query);

				String dateStr = order.getOrderDate().toString();
				DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				Date date = (Date) formatter.parse(dateStr);

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
						+ cal.get(Calendar.YEAR);
				System.out.println("formatedDate : " + formatedDate);

				pstmt.setInt(1, order.getOrderId());
				pstmt.setString(2, formatedDate);
				pstmt.setInt(3, order.getId());
				pstmt.setDouble(4, order.getTotalAmount());

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
	public List<Order> getAllOderDetails() throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from orderproduct");
			List<Order> orders = new ArrayList<Order>();
			Order order;
			while (result.next()) {
				order = new Order();
				order.setOrderId(result.getInt("id"));
				order.setId(result.getInt("cartId"));
				order.setOrderDate(result.getDate("orderDate"));
				order.setTotalAmount(result.getInt("total"));
				orders.add(order);
			}
			con.close();
			return orders;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	@Override
	public void deleteOrder(int id) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "delete from orderproduct where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.cleanup(con, stmt, null);
		}
	}

	@Override
	public Order getOrderDetails(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con.prepareStatement("select count(*) from orderproduct where id = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt.executeQuery("select * from orderproduct where id = " + id);
				Order order = new Order();
				while (result.next()) {
					order.setOrderId(result.getInt("id"));
					order.setId(result.getInt("cartId"));
					order.setOrderDate(result.getDate("orderDate"));
					order.setTotalAmount(result.getInt("total"));
				}
				return order;
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
	public Order getOrderCartDetails(int cartid) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con.prepareStatement("select count(*) from orderproduct where cartid = ?");
			pstmt.setInt(1, cartid);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt.executeQuery("select * from orderproduct where cartid = " + cartid);
				Order order = new Order();
				while (result.next()) {
					order.setOrderId(result.getInt("id"));
					order.setId(result.getInt("cartId"));
					order.setOrderDate(result.getDate("orderDate"));
					order.setTotalAmount(result.getInt("total"));
				}
				return order;
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
