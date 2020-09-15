package com.zensar.order.processing.service;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.NegativePriceException;
import com.zensar.order.processing.exceptions.NegativeQuantityException;
import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.repository.OrderRepository;
import com.zensar.order.processing.repositoryprovider.OrderRepositoryProvider;

public class OrderServiceImpl implements OrderService {

	OrderRepository orImpl = OrderRepositoryProvider.getRepository();

	@Override
	public int placeOrder(String orderName, double orderPrice, int orderQuantity, String orderDate)
			throws NegativePriceException, NegativeQuantityException {
		if (orderPrice < 0) {
			throw new NegativePriceException("Order Price Should be greater than zero");
		}

		if (orderQuantity < 0) {
			throw new NegativeQuantityException("Order Quantity Should be greater than zero");
		}
		return orImpl.createOrder(new Order(orderName, orderPrice, orderQuantity, orderDate));

	}

	@Override
	public Order[] displayAllOrders() {
		return orImpl.displayAllOrders();
	}

	@Override
	public Order getOrder(int orderId) throws OrderNotFoundException {

		return orImpl.getOrder(orderId);
	}

	@Override
	public Order updateOrder(int orderId) throws OrderNotFoundException {
		return orImpl.updateOrder(orderId);
	}

	@Override
	public boolean deleteOrder(int orderId) throws OrderNotFoundException {

		return orImpl.deleteOrder(orderId);
	}

}
