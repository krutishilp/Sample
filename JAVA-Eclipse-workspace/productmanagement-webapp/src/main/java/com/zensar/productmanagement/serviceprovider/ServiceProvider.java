package com.zensar.productmanagement.serviceprovider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.productmanagement.service.ProductService;

public class ServiceProvider {

	public static ProductService provideService() {
		Properties property = new Properties();
		ProductService serviceProvider = null;
		try {
			property.load(new FileReader("D:\\Zensar_FullStack Training\\JAVA\\JAVA-Eclipse-workspace\\productmanagement-webapp\\src\\main\\resources\\serviceandrepositoryprovider.properties"));
			String service = property.getProperty("service.provider");
			serviceProvider = (ProductService) Class.forName(service).newInstance();
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
