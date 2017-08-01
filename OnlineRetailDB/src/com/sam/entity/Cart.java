package com.sam.entity;

public class Cart {
	private int id;
	private int prodId;
	private int qty;
	private int userId;
	
	public Cart() {
		
	}
	
	public Cart(int id, int prodId, int qty, int userId) {
		super();
		this.id = id;
		this.prodId = prodId;
		this.qty = qty;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
		
}
