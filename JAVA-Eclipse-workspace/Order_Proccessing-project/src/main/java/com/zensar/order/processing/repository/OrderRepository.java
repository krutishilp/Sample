package com.zensar.order.processing.repository;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.OrderNotFoundException;

public interface OrderRepository {

	int createOrder(Order order);

	Order[] displayAllOrders();

	Order getOrder(int orderId) throws OrderNotFoundException;

	Order updateOrder(int orderId,double orderPrice,int orderQuantity) throws OrderNotFoundException;

	boolean deleteOrder(int orderId) throws OrderNotFoundException;
	int updateParticularOrder(Order order) throws OrderNotFoundException;
}
