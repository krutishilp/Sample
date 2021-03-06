package com.zensar.order.processing.beans;

public class Order {

	private int orderId;
	private String orderName;
	private double orderPrice;
	private int orderQuantity;
	private String orderDate;

	public Order() {

	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public Order(int orderId, String orderName, double orderPrice, int orderQuantity, String orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	public Order(String orderName, double orderPrice, int orderQuantity, String orderDate) {
		super();
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate + "]";
	}

}
