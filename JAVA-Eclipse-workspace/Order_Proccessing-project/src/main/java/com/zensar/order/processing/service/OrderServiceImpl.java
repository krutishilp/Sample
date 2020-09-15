package com.zensar.order.processing.service;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.NegativePriceException;
import com.zensar.order.processing.exceptions.NegativeQuantityException;
import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.repository.OrderRepository;
import com.zensar.order.processing.repositoryprovider.OrderRepositoryProvider;

public class OrderServiceImpl implements OrderService {

	OrderRepository orImpl = OrderRepositoryProvider.getRepository();

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

	public Order[] displayAllOrders() {
		return orImpl.displayAllOrders();
	}

	public Order getOrder(int orderId) throws OrderNotFoundException {
		return orImpl.getOrder(orderId);
	}

	public Order updateOrder(int orderId,double orderPrice,int orderQuantity) throws OrderNotFoundException {
		return orImpl.updateOrder(orderId,orderPrice,orderQuantity);
	}

	public boolean deleteOrder(int orderId) throws OrderNotFoundException {

		return orImpl.deleteOrder(orderId);
	}

	public int updateParticularOrder(int orderId,String orderName,double orderPrice,int orderQuantity,String orderDate) throws OrderNotFoundException {
		Order or=new Order(orderId, orderName, orderPrice, orderQuantity, orderDate);
		return orImpl.updateParticularOrder(or);
	}

}
