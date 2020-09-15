package com.zensar.order.processing.view;

import java.util.Scanner;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.NegativePriceException;
import com.zensar.order.processing.exceptions.NegativeQuantityException;
import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

public class OrderProcessingClient {

	public static void main(String[] args) {

		OrderService os = OrderServiceProvider.getService();
		Scanner sc = new Scanner(System.in);
		String resp = "", response = "";
		int choice;
		int orderId;
		Order order = null;

		do {
			System.out.println("**************** Welcome to Order Processing System *****************");
			System.out.println("1.Place an Order");
			System.out.println("2.Display All Orders");
			System.out.println("3.Get Particular Order");
			System.out.println("4.Update an Order");
			System.out.println("5.Delete an Order");

			System.out.println("Please Enter Your Choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				do {
					System.out.println("Please Enter Order Name:");
					String orderName = sc.next();
					System.out.println("Please Enter Order Price:");
					double orderPrice = sc.nextDouble();
					System.out.println("Please Enter Order Quantity:");
					int orderQuantity = sc.nextInt();
					System.out.println("Please Enter Order Date (DD/MM/YYYY):");
					String orderDate = sc.next();

					int result;
					try {
						result = os.placeOrder(orderName, orderPrice, orderQuantity, orderDate);
						if (result > 0) {
							System.out.println("Order Placed Successfully with OrderId: " + result);
						} else {
							System.out.println("Order Insertion Failed !!");
						}
					} catch (NegativePriceException e) {
						System.out.println("Sorry, Order Price Should not be less than Zero");
					} catch (NegativeQuantityException e) {
						System.out.println("Sorry, Order Quantity Should not be less than Zero");
					}

					System.out.println("Do you want to place more Orders ?(Yes/No)");
					resp = sc.next();
				} while (resp.equalsIgnoreCase("Yes"));

				break;
			case 2:
				Order[] orders = os.displayAllOrders();
				for (Order or : orders) {
					if (or != null) {
						System.out.println(or);
					}
				}
				break;
			case 3:
				System.out.println("Please Enter Order Id:");
				orderId = sc.nextInt();
				try {
					order = os.getOrder(orderId);
					System.out.println(order);
				} catch (OrderNotFoundException e) {
					System.out.println("Sorry, Order with Id: " + orderId + " not Found !!");
				}
				break;
			case 4:
				System.out.println("Please Enter Order Id:");
				orderId = sc.nextInt();
				try {
					order = os.updateOrder(orderId);
					System.out.println("Updated order: " + order);
				} catch (OrderNotFoundException e1) {
					System.out.println("Sorry, Order with Id: " + orderId + " not Found !!");
				}
				break;
			case 5:
				System.out.println("Please Enter Order Id:");
				orderId = sc.nextInt();
				boolean or = false;
				try {
					or = os.deleteOrder(orderId);
				} catch (OrderNotFoundException e) {
					System.out.println("Sorry, Order with Id: " + orderId + " not Found !!");
				}
				if (or) {
					System.out.println("Order Deleted Successfully !!");
				}
				break;
			default:
				System.out.println("Invalid Choice..");
			}

			System.out.println("Do you want to Continue ?(Yes/No)");
			response = sc.next();
			if (response.equalsIgnoreCase("No")) {
				System.out.println("Thank you for using our Services !!");
			}
		} while (response.equalsIgnoreCase("Yes"));
	}

}
