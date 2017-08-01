package com.sam.dao.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionHelper {

	public static Connection getMySqlConnection () throws ClassNotFoundException, SQLException, IOException
	{
		//Load the driver
					Class.forName("oracle.jdbc.driver.OracleDriver");


		//To get the connection we need url, user, password
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "sam";
            String pwd = "sam";

		Connection conn=DriverManager.getConnection(url, user, pwd);
		return conn;

	}

	public static void cleanup(Connection conn, Statement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cleanup(Connection conn, PreparedStatement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
