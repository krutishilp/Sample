package com.zensar.view;

import java.util.Scanner;

import com.zensar.beans.Product;
import com.zensar.service.ProductService;

import ServiceProvider.ServiceProvider;

public class ProductClient {

	public static void main(String[] args) {
		ProductService psl = ServiceProvider.provideService();
		Scanner sc = new Scanner(System.in);
		int productId;
		Product product;
		String response = "No";
		String ch = "No";
		do {
			System.out.println("Welcome to the Product Management System");
			System.out.println("1.Insert Product");
			System.out.println("2.Display all Product");
			System.out.println("3.Get Particular Product");
			System.out.println("4.Delete Particular Product");

			System.out.println("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				do {
					System.out.println("Please Enter Product Name: ");
					String productName = sc.next();

					System.out.println("Please Enter Product Cost: ");
					int productCost = sc.nextInt();

					int employeeId = psl.acceptProduct(productName, productCost);

					System.out.println("Product registerd Successfully with " + employeeId);

					System.out.println("Would you like to add more Products(Yes/No)??");
					response = sc.next();

				} while (response.equalsIgnoreCase("Yes"));
				break;

			case 2:
				Product[] allProducts = psl.getAllProducts();

				for (Product pr : allProducts) {
					if (pr != null) {
						System.out.println(pr);
					}
				}
				break;
			case 3:
				System.out.println("Please Enter the Product Id");
				productId = sc.nextInt();
				product = psl.getProduct(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Sorry,Product Not Found");
				}
				break;
			case 4:
				System.out.println("Please Enter the Product Id");
				productId = sc.nextInt();
				boolean flag = psl.deleteProduct(productId);
				if(flag) {
					System.out.println("Product Deleted Successfully..");
				}else {
					System.out.println("Product Not Found");
				}
				break;
			default:
				System.out.println("Sorry,Invalid Choice..");
			}

			System.out.println("Would you like Continue(Yes/No)??");
			ch = sc.next();

			if (!ch.equalsIgnoreCase("yes")) {
				System.out.println("Thank you for using our Service....");
			}
		} while (ch.equalsIgnoreCase("Yes"));
	}

}
