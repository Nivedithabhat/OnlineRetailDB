package com.sam.dao.impl;

import com.sam.dao.*;
import com.sam.entity.*;

import java.util.*;
import java.sql.*;

import static com.sam.dao.impl.ConnectionHelper.*;

public class UserDaoImpl implements UserDao {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	@Override
	public List<User> getAllUser() throws DaoException {
		try {
			con = getMySqlConnection();

			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from reg");
			List<User> userList = new ArrayList<User>();
			while (result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
				user.setPhnnumber(result.getString("phno"));
				user.setGender(result.getString("gender"));
				user.setCity(result.getString("city"));
				user.setCountry(result.getString("country"));
				userList.add(user);
			}
			con.close();
			return userList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

	@Override
	public int addUser(User user) throws DaoException {
		try {
			int cnt = 0;
			con = ConnectionHelper.getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from reg where username = '"
							+ user.getUsername() + "'");
			result.next();
			int count = result.getInt(1);
			stmt.close();

			stmt = (Statement) con.createStatement();
			result = stmt
					.executeQuery("select count(*) from reg where id = '"
							+ user.getId() + "'");
			result.next();
			int count1 = result.getInt(1);
			stmt.close();

			if (count == 0 && count1 == 0) {
				String query = "insert into reg(id,username,phno,gender,city,country)"
						+ " values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, user.getId());
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getPhnnumber());
				pstmt.setString(4, user.getGender());
				pstmt.setString(5, user.getCity());
				pstmt.setString(6, user.getCountry());
				cnt = pstmt.executeUpdate();
			} else {
				System.out.println("Information already exists");
			}
			return cnt;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void updateUser(User user) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "update reg set phno = ?, city = ?, country = ? where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPhnnumber());
			pstmt.setString(2, user.getCity());
			pstmt.setString(3, user.getCountry());
			pstmt.setInt(4, user.getId());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public void deleteUser(int Id) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "delete from reg where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Id);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.cleanup(con, stmt, null);
		}
	}

	public User getUser(int userId) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from reg where id = ?");
			pstmt.setInt(1, userId);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt.executeQuery("select * from reg where id = "
						+ userId);
				User user = new User();
				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setUsername(result.getString("username"));
					user.setPhnnumber(result.getString("phno"));
					user.setGender(result.getString("gender"));
					user.setCity(result.getString("city"));
					user.setCountry(result.getString("country"));
				}
				con.close();
				return user;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionHelper.cleanup(con, stmt, result);
		}
	}

	public User getUsersByMobileNumber(String mobileNo) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from reg where phno = ?");
			pstmt.setString(1, mobileNo);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt.executeQuery("select * from reg where phno = "
						+ mobileNo);
				User user = new User();
				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setUsername(result.getString("username"));
					user.setPhnnumber(result.getString("phno"));
					user.setGender(result.getString("gender"));
					user.setCity(result.getString("city"));
					user.setCountry(result.getString("country"));
				}
				con.close();
				return user;
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
