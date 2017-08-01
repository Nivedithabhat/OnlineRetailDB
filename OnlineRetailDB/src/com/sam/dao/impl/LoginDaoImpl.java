package com.sam.dao.impl;

import static com.sam.dao.impl.ConnectionHelper.cleanup;
import static com.sam.dao.impl.ConnectionHelper.getMySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sam.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {


	@Override
	public int loginValidate(String username,String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			con = getMySqlConnection();
			stmt = con.prepareStatement("select count(*) from registration where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			
			result.next();
			int cnt = result.getInt(1);
			con.close();
			return cnt;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}

}
