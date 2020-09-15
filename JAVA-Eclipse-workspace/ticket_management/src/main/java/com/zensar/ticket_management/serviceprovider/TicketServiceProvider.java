package com.zensar.ticket_management.serviceprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.ticket_management.service.TicketService;

public class TicketServiceProvider {

	public static TicketService getService() {
		Properties property = new Properties();
		TicketService serviceProvider = null;
		try {
			
			property.load(new FileReader("./src/main/resources/serviceprovider.properties"));
			String service = property.getProperty("service.provider");
			serviceProvider = (TicketService) Class.forName(service).newInstance();

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
