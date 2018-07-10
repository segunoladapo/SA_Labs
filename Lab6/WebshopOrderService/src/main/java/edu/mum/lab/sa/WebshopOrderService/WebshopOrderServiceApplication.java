package edu.mum.lab.sa.WebshopOrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class WebshopOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopOrderServiceApplication.class, args);
	}
}
