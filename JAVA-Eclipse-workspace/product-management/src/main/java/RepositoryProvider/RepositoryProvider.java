package RepositoryProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.repository.ProductRepository;
import com.zensar.service.ProductService;

public class RepositoryProvider {

	public static ProductRepository provideService() {
		Properties property = new Properties();
		ProductRepository repositoryProvider = null;
		try {
			property.load(new FileReader("./src/main/resources/serviceandrepositoryprovider.properties"));
			String service = property.getProperty("repository.provider");
			repositoryProvider = (ProductRepository) Class.forName(service).newInstance();
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
