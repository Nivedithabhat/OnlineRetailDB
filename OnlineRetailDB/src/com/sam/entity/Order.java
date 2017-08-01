package com.sam.entity;

import java.util.*;

public class Order {
	private int orderId;
	private Date orderDate;
	private int id;
	private double totalAmount;
	
	public Order() {
		
	}
	
	public Order(Date orderDate, int id, double totalAmount) {
		super();
		this.orderDate = orderDate;
		this.id = id;
		this.totalAmount = totalAmount;
	}

	public Order(int orderid, Date orderDate, int id, double totalAmount) {
		super();
		this.orderId = orderid;
		this.orderDate = orderDate;
		this.id = id;
		this.totalAmount = totalAmount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
		
}
