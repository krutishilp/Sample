package com.zensar.order.processing.service;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.NegativePriceException;
import com.zensar.order.processing.exceptions.NegativeQuantityException;
import com.zensar.order.processing.exceptions.OrderNotFoundException;

public interface OrderService {

	int placeOrder(String orderName, double orderPrice, int orderQuantity, String orderDate)
			throws NegativePriceException, NegativeQuantityException;

	Order[] displayAllOrders();

	Order getOrder(int orderId) throws OrderNotFoundException;

	Order updateOrder(int orderId,double orderPrice,int orderQuantity) throws OrderNotFoundException;

	boolean deleteOrder(int orderId) throws OrderNotFoundException;
	
	int updateParticularOrder(int orderId,String orderName,double orderPrice,int orderQuantity,String orderDate) throws OrderNotFoundException;
}
