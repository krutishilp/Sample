package com.zensar.order.processing.repository;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.OrderNotFoundException;

public interface OrderRepository {

	int createOrder(Order order);

	Order[] displayAllOrders();

	Order getOrder(int orderId) throws OrderNotFoundException;

	Order updateOrder(int orderId) throws OrderNotFoundException;

	boolean deleteOrder(int orderId) throws OrderNotFoundException;
}
