package com.zensar.order.processing.repository;

import java.util.Scanner;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.OrderNotFoundException;

public class OrderRepositoryImpl implements OrderRepository {

	private Order[] orders = new Order[10];
	static int index, orderId = 100;

	@Override
	public int createOrder(Order order) {
		order.setOrderId(orderId++);
		orders[index++] = order;
		return order.getOrderId();
	}

	@Override
	public Order[] displayAllOrders() {
		return orders;
	}

	@Override
	public Order getOrder(int orderId) throws OrderNotFoundException {
		Order order = null;
		boolean flag=false;
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null) {
				if (orders[i].getOrderId() == orderId) {
					order = orders[i];
					flag=true;
					return order;
				}
			}
		}
		if(!flag) {
			throw new OrderNotFoundException("Order Not Present");
		}
		return order;
	}

	@Override
	public Order updateOrder(int orderId) throws OrderNotFoundException {
		Order order = null;
		boolean flag=false;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null) {
				if (orders[i].getOrderId() == orderId) {
					System.out.println("Please Enter new Price of an Order:");
					double orderPrice = sc.nextDouble();
					System.out.println("Please Enter new Quantity of an Order:");
					int orderQuantity = sc.nextInt();
					orders[i].setOrderPrice(orderPrice);
					orders[i].setOrderQuantity(orderQuantity);
					order = orders[i];
					flag=true;
					break;
				}
			}
		}
		if(!flag) {
			throw new OrderNotFoundException("Order Not Present");
		}
		return order;
	}

	@Override
	public boolean deleteOrder(int orderId) throws OrderNotFoundException {
		boolean flag=false;
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null) {
				if (orders[i].getOrderId() == orderId) {
					orders[i] = null;
					flag=true;
					return true;
				} 
			}
		}
		if(!flag) {
			throw new OrderNotFoundException("Order Not Present");
		}
		return false;
	}

}
