package com.zensar.order.processing.repositoryprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.order.processing.repository.OrderRepository;

public class OrderRepositoryProvider {

	public static OrderRepository getRepository() {
		Properties property = new Properties();
		OrderRepository repositoryProvider = null;
		try {
			property.load(new FileReader("D:\\\\Zensar_FullStack Training\\\\JAVA\\\\JAVA-Eclipse-workspace\\\\Order_Proccessing-project\\\\src\\\\main\\\\resources\\\\serviceprovider.properties"));
			String service = property.getProperty("repository.provider");
			repositoryProvider = (OrderRepository) Class.forName(service).newInstance();
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

		return repositoryProvider;
	}
}
