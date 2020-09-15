package com.zensar.ticket_management.repositoryprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.ticket_management.repository.TicketRepository;

public class TicketRepositoryProvider {

	public static TicketRepository getRepository() {
		Properties property = new Properties();
		TicketRepository repositoryProvider = null;
		try {
			property.load(new FileReader("./src/main/resources/serviceprovider.properties"));
			String service = property.getProperty("repository.provider");
			repositoryProvider = (TicketRepository) Class.forName(service).newInstance();
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
