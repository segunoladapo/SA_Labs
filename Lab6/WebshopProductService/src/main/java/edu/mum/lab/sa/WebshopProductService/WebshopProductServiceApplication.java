package edu.mum.lab.sa.WebshopProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class WebshopProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopProductServiceApplication.class, args);
	}


}
