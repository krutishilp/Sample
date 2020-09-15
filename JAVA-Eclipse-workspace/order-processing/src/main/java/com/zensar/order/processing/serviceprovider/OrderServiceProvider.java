package com.zensar.order.processing.serviceprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.order.processing.service.OrderService;

public class OrderServiceProvider {

	public static OrderService getService() {
		Properties property = new Properties();
		OrderService serviceProvider = null;
		try {
			
			property.load(new FileReader("./src/main/resources/serviceprovider.properties"));
			String service = property.getProperty("service.provider");
			serviceProvider = (OrderService) Class.forName(service).newInstance();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serviceProvider;
	}

}
