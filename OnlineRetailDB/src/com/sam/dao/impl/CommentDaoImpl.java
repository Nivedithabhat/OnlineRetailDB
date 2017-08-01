package com.sam.dao.impl;

import com.sam.dao.*;
import com.sam.entity.*;

import java.sql.*;
import java.util.*;

import static com.sam.dao.impl.ConnectionHelper.*;

public class CommentDaoImpl implements CommentDao {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;

	@Override
	public void addComment(Comment comment) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "insert into comments(id,categoryid,remarks)"
					+ " values(Comment_seq.nextval,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, comment.getCategoryId());
			pstmt.setString(2, comment.getComment());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, null);
		}
	}

	@Override
	public List<Comment> getAllComments() throws DaoException {
		try {
			con = getMySqlConnection();
			stmt = (Statement) con.createStatement();
			result = stmt.executeQuery("select * from comments");
			List<Comment> comments = new ArrayList<Comment>();
			Comment comment;
			while (result.next()) {
				comment = new Comment();
				comment.setId(result.getInt("id"));
				comment.setCategoryId(result.getInt("categoryId"));
				comment.setComment(result.getString("remarks"));
				comments.add(comment);
			}
			con.close();
			return comments;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, stmt, result);
		}
	}


	@Override
	public void deleteComment(int id) throws DaoException {
		try {
			con = getMySqlConnection();
			String query = "delete from comments where id = ?";
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
	public Comment getComment(int id) throws DaoException {
		try {
			con = ConnectionHelper.getMySqlConnection();
			pstmt = con
					.prepareStatement("select count(*) from comments where id = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			result.next();
			int count = result.getInt(1);

			if (count > 0) {
				stmt = (Statement) con.createStatement();
				result = stmt.executeQuery("select * from comments where id = "
						+ id);
				Comment comment = new Comment();
				while (result.next()) {
					comment.setId(result.getInt("id"));
					comment.setCategoryId(result.getInt("categoryId"));
					comment.setComment(result.getString("remarks"));
				}
				return comment;
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
