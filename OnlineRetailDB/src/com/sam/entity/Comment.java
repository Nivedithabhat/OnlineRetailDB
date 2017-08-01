package com.sam.entity;

public class Comment {
	private int id;
	private int categoryId;
	private String comment;

	public Comment() {

	}

	public Comment(int categoryId, String comment) {
		super();
		this.categoryId = categoryId;
		this.comment = comment;
	}

	public Comment(int id, int categoryId, String comment) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comment == null) ? 0 : comment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

}
