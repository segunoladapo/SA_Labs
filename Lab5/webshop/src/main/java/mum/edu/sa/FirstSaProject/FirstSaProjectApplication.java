package mum.edu.sa.FirstSaProject;

import mum.edu.sa.FirstSaProject.order.component.jms.JmsSender;
import mum.edu.sa.FirstSaProject.order.component.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class FirstSaProjectApplication implements CommandLineRunner {

	@Autowired
	private JmsSender jmsSender;

	public static void main(String[] args) {
		SpringApplication.run(FirstSaProjectApplication.class, args);
	}

	public  void run(String... args) throws Exception{
		Product product = new Product();
		product.setDescription("Hello Product");
		product.setPrice(100.00);
		product.setProductNo(11111);
		jmsSender.sendJmsMessage(product);
	}
}
