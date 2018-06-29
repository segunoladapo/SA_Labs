package rest;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
		//System.out.println("Receiving message:" + greeting.getContent());
		/*
		Product product3 = new Product();
		product3.setDescription("Samsung SmartPhone");
		product3.setPrice(34.00);
		product3.setProductNo(3);

		Product product4 = new Product();
		product4.setDescription("FlatScreen Monitor");
		product4.setPrice(56.00);
		product4.setProductNo(4);

		//add both products to database
		restTemplate.postForObject("http://localhost:8080/product", product3, Object.class);
		restTemplate.postForObject("http://localhost:8080/product", product4, Object.class);

		restTemplate.postForObject("http://localhost:8080/shopping/" + 2, null, Object.class);
*/
	/*	restTemplate.postForObject(String.format("http://localhost:8080/shopping/orderline/%d/%d/%d",2,3,6)
				, null, Object.class);


		restTemplate.postForObject(String.format("http://localhost:8080/shopping/orderline/%d/%d/%d",2,4,8)
				, null, Object.class);
*/


		restTemplate.postForObject(String.format("http://localhost:8080/shopping/checkout/%d",2)
				, null, Object.class);
	}

}
